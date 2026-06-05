package org.scoula.travel.dao;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelDaoImpl implements TravelDao{

    Connection conn = JDBCUtil.getConnection();

    // 여행지 추가
    @Override
    public void insert(TravelVO travel) {
        String sql = "insert into tbl_travel(no, district,title,description, address, phone) values(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, travel.getNo());
            pstmt.setString(2, travel.getDistrict());
            pstmt.setString(3, travel.getTitle());
            pstmt.setString(4, travel.getDescription());
            pstmt.setString(5, travel.getAddress());
            pstmt.setString(6, travel.getPhone());

            int count = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void insertImage(TravelImageVO image) {

        String sql = "insert into tbl_travel_image(filename, travel_no) values(?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, image.getFilename());
            pstmt.setLong(2, image.getTravelNo());

            int count = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int getTotalCount() {

        String sql = "select count(*) from tbl_travel";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();  // JDBC 결과 집합
        ){
            // ResultSet 생성 직후에 가리키는 행이 없음
            rs.next();
            // 인덱스로 Int값 가져오기
            return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // 지역 목록 조회
    @Override
    public List<String> getDistricts() {

        List<String> districts = new ArrayList<>();

        String sql = "select distinct district from tbl_travel order by district";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                // 단일 컬럼(district)만 조회
                String district = rs.getString("district");
                districts.add(district);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return districts;
    }


    // 목록 전체 조회
    @Override
    public List<TravelVO> getTravels() {
        List<TravelVO> travels = new ArrayList<>();  // 결과를 담아줄 List

        String sql = "select * from tbl_travel order by district, title";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();  // JDBC 결과 집합
        ){
            while (rs.next()) {
                // 조회한 행마다 매핑 통해 VO 객체로 반환
                TravelVO travel = map(rs);
                travels.add(travel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    private TravelVO map(ResultSet rs) throws SQLException {
        /*
        Builder Pattern
        - 단계적으로 값 설정, 객체 생성
        - 필드가 많거나 선택적으로 입력값이 많은 객체 만들때 사용
        - 가독성이 좋음
         */
        return TravelVO.builder()
                .no(rs.getLong("no"))
                .district(rs.getString("district"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .address(rs.getString("address"))
                .phone(rs.getString("phone"))
                .build();
    }


    // 페이징 된 목록 처리
    @Override
    public List<TravelVO> getTravels(int page) {

        List<TravelVO> travels = new ArrayList<>();  // 결과를 담아줄 List

        String sql = "select * from tbl_travel order by district, title limit ?, ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);){

            int count = 10;
            int start = (page - 1) * count;

            pstmt.setInt(1, start);  // 시작할 인덱스 번호 (limit ?,?의 첫번째 물음표)
            pstmt.setInt(2, count);  // 몇개를 가지고 올지 (limit ?,?의 두번째 물음표)

            try(ResultSet rs = pstmt.executeQuery();) {  // JDBC 결과 집합
                while (rs.next()) {

                    // 조회한 행마다 매핑 통해 VO 객체로 반환
                    TravelVO travel = map(rs);
                    travels.add(travel);
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }


    // 입력받은 지역 조회
    @Override
    public List<TravelVO> getTravels(String district) {

        List<TravelVO> travels = new ArrayList<>();  // 결과를 담아줄 List

        String sql = "select * from tbl_travel where tbl_travel.district = ? order by title";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);){

            pstmt.setString(1, district);

            try(ResultSet rs = pstmt.executeQuery();) {  // JDBC 결과 집합
                while (rs.next()) {

                    // 조회한 행마다 매핑 통해 VO 객체로 반환
                    TravelVO travel = map(rs);
                    travels.add(travel);
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }


    @Override
    public Optional<TravelVO> getTravel(Long no) {
        TravelVO travel = null;

        String sql = """
            select t.*, ti.no as tino, ti.filename, ti.travel_no
            from tbl_travel t
            left join tbl_travel_image ti
            on t.no = ti.travel_no
            where t.no = ?
            """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setLong(1, no);

            try(ResultSet rs = pstmt.executeQuery();) { // JDBC 결과 집합

                // 조회한 데이터가 없으면 Optional.empty(); 반환
                // 있으면 Optional로 VO 감싸서 반환
                if(rs.next()) {
                    travel = map(rs);

                    // 이미지 목록
                    List<TravelImageVO> images = new ArrayList<>();
                    do {
                        TravelImageVO image = TravelImageVO.builder()
                                .no(rs.getLong("tino"))
                                .filename(rs.getString("filename"))
                                .travelNo(rs.getLong("travel_no"))
                                .build();

                        images.add(image);

                    } while (rs.next());

                    travel.setImages(images);

                    return Optional.of(travel);
                } else {
                    return Optional.empty();
                }

            } catch (SQLException e) {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
