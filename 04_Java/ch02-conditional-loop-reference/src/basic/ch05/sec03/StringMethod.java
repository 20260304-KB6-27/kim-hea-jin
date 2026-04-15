package basic.ch05.sec03;

public class StringMethod {
    public static void main(String[] args) {

        String subject = "자바 프로그래밍";

        // str.length(): 문자열의 길이 반환
        System.out.println(subject.length());
        
        // str.indexOf(): 처음 등장하는 위치의 인덱스 반환, 못찾으면 -1 반환
        int idx = subject.indexOf("프로그래밍");
        System.out.println("idx = " + idx);

        // str.split(): 문자열을 특정 구분자 기준으로 잘라 문자열 배열로 반환
        // 정규식을 구분자로 사용 가능
        String[] splitstr = subject.split(" ");

        System.out.println(splitstr[0]);
        System.out.println(splitstr[1]);

        // str.subString(startIdx, endIdx): 원하는 범위만 잘라서 새로운 문자열 반환
        // startIdx부터 endIdx까지의 범위 반환 (endIdx없으면 끝까지)
        String subString = subject.substring(idx);
        System.out.println(subString);  // 프로그래밍

        String subString2 = subject.substring(idx, idx+2);
        System.out.println(subString2); // 프로

        // str.replace(target, replacement): str의 target을 replacement로 변경
        // target: 바꿀 대상
        // replacement: 바꿀값
        String replaceStr = subject.replace("래밍", "램");
        System.out.println(replaceStr); // 자바 프로그램
    }
}
