package lib_package;

import java.time.Month;
import  java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {

    /**
     * https://injae7034.github.io/java/nineteenth/
     * 라이브러리 만들기 참고
     * */

    private int year;
    private Month month;
    private int day;
    private DayOfWeek dayOfWeek;


    public Date(int year, int month, int day)
    {
        this.year = year;
        this.month = Month.of(month);
        this.day = day;
        this.dayOfWeek = LocalDate.of(year, month, day).getDayOfWeek();
    }

    public Date(String date)
    {
        LocalDate localDate = LocalDate.of(Integer.parseInt(date.substring(0,4)),
                Integer.parseInt(date.substring(4,6)),Integer.parseInt(date.substring(6,8)));
        this.year = localDate.getYear();
        this.month = localDate.getMonth();
        this.day = localDate.getDayOfMonth();
        this.dayOfWeek = localDate.getDayOfWeek();
    }

    //오늘 날짜 생성
    public static Date today()
    {
        LocalDate localDate = LocalDate.now();
        return new Date(localDate.getYear(), localDate.getMonth().getValue(),
                localDate.getDayOfMonth());
    }

    //어제 날짜 생성
    public static Date yesterday()
    {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return  new Date(yesterday.getYear(), yesterday.getMonth().getValue(),
                yesterday.getDayOfMonth());
    }

    //내일 날짜 생성
    public static Date tomorrow()
    {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return new Date(tomorrow.getYear(), tomorrow.getMonth().getValue(),
                tomorrow.getDayOfMonth());
    }
}
