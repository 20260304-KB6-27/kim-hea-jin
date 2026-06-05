package org.scoula.travel.service;

import lombok.RequiredArgsConstructor;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {

    // 객체 생성 시 한 번만 초기화
    final TravelDao dao;

    // TravelVO List를 받아서 출력
    private void printTravels(List<TravelVO> travels) {
        for (TravelVO travel : travels) {
            System.out.printf("%3d %6s %s\n", travel.getNo(), travel.getDistrict(), travel.getTitle());
        }
    }


    /*
    모든 목록 조회해서 콘솔로 출력
     */
    @Override
    public void printTravels() {
        List<TravelVO> travels = dao.getTravels();

        printTravels(travels);
    }


    /*
    지역으로 여행지 조회
    1. 지역 목록 조회
    2. 사용자가 선택한 지역 검색 후 조회
     */
    @Override
    public void printTravelsByDistrict() {

        // 지역 목록 조회
        List<String> districts = dao.getDistricts();

        System.out.println("지역 목록");
        for (int i = 0; i < districts.size(); i++) {
            System.out.printf("%d. %s\t", (i + 1), districts.get(i));
        }
        System.out.println("");

        // 사용자에게 지역 입력 받기
        String district = getString(String.format("지역 선택: "));

        // 입력받은 지역 조회
        List<TravelVO> travels = dao.getTravels(district);

        // 출력
        printTravels(travels);
    }

    // Scanner 지역이름 입력받는 메서드
    private String getString(String prompt) {
        System.out.println(prompt);

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        return string;
    }


    /*
    목록 페이징 조회 (10개 단위)
    - 총 페이지 갯수 주회를 위해 전체 목록 갯수 조회
    - 페이징 처리된 조회
     */
    @Override
    public void printTravelsByPage() {

        // 홈페이지 개수
        int totalPage = (int) Math.ceil(dao.getTotalCount() / 10);

        System.out.printf("총 %d 페이지\n", totalPage);

        // 사용자에게 입력 받기
        int page = getNumber(String.format("페이지 선택(1 ~ %d)", totalPage));

        // page대로 조회
        List<TravelVO> travels = dao.getTravels(page);

        // 출력
        printTravels(travels);

    }

    // Scanner 숫자값 입력받는 메서드
    private int getNumber(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        return num;
    }

    /*
    단건 조회
    - no 기준 단건 조회
    - image join 조회
     */
    @Override
    public void printTravel() {
        long no = getNumber("관광지 no: ");

        // Optional.orElseThrow();
        // Optional 객체 안에 값이 있으면 값 반환, 없으면 지정한 예외 던짐
        TravelVO travel = dao.getTravel(no)
                .orElseThrow(() -> new NoSuchElementException());

        // 결과 출력
        System.out.println("권역: " + travel.getDistrict());
        System.out.println("제목: " + travel.getTitle());
        System.out.println("설명: " + travel.getDescription());
        System.out.println("주소: " + travel.getAddress());
        System.out.println("전화번호: " + travel.getPhone());
        System.out.println("사진들");
        for (TravelImageVO image : travel.getImages()) {
            System.out.printf(" [%3d] %s\n", image.getNo(), image.getFilename());
        }
    }
}
