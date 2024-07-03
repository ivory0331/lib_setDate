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

    // 2024, 07, 01 날짜 버전
    public Date(int year, int month, int day)
    {
        this.year = year;
        this.month = Month.of(month);
        this.day = day;
        this.dayOfWeek = LocalDate.of(year, month, day).getDayOfWeek();
    }

    // 20240701 날짜 버전
    public Date(String date)
    {
        LocalDate localDate = LocalDate.of(Integer.parseInt(date.substring(0,4)),
                Integer.parseInt(date.substring(4,6)),Integer.parseInt(date.substring(6,8)));
        this.year = localDate.getYear();
        this.month = localDate.getMonth();
        this.day = localDate.getDayOfMonth();
        this.dayOfWeek = localDate.getDayOfWeek();
    }

    // 오늘 날짜 생성
    public static Date today()
    {
        LocalDate localDate = LocalDate.now();
        return new Date(localDate.getYear(), localDate.getMonth().getValue(),
                localDate.getDayOfMonth());
    }

    // 어제 날짜 생성
    public static Date yesterday()
    {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return  new Date(yesterday.getYear(), yesterday.getMonth().getValue(),
                yesterday.getDayOfMonth());
    }

    // 내일 날짜 생성
    public static Date tomorrow()
    {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return new Date(tomorrow.getYear(), tomorrow.getMonth().getValue(),
                tomorrow.getDayOfMonth());
    }

    // 오늘 날짜기준으로 매개변수로 입력한 날짜만큼 이전 날짜 생성
    public static Date previousDate(int days)
    {
        LocalDate previousDate = LocalDate.now().minusDays(days);
        return new Date(previousDate.getYear(), previousDate.getMonth().getValue(),
                previousDate.getDayOfMonth());
    }

    // 매개변수로 입력받은 Date를 매개변수로 입력한 날짜만큼 이전 날짜 생성
    public static Date previousDate(Date date, int days)
    {
        LocalDate previousDate = LocalDate.of(date.year,
                date.month.getValue(), date.day).minusDays(days);
        return new Date(previousDate.getYear(), previousDate.getMonth().getValue(),
                previousDate.getDayOfMonth());
    }

    // 오늘 날짜기준으로 매개변수로 입력한 날짜만큼 이후 날짜 생성
    public static Date nextDate(int days)
    {
        LocalDate nextDate = LocalDate.now().plusDays(days);
        return new Date(nextDate.getYear(), nextDate.getMonth().getValue(),
                nextDate.getDayOfMonth());
    }

    // 매개변수로 입력받은 Date를 매개변수로 입력한 날짜만큼 이후 날짜 생성
    public static Date nextDate(Date date, int days)
    {
        LocalDate nextDate = LocalDate.of(date.year,
                date.month.getValue(), date.day).plusDays(days);
        return new Date(nextDate.getYear(), nextDate.getMonth().getValue(),
                nextDate.getDayOfMonth());
    }

    // 날짜 비교 (어떤것이 더 큰지)
    public boolean isGreaterThan(Date other)
    {
        boolean ret = false;
        if (this.year > other.year)
        {
            ret = true;
        }
        else if (this.year == other.year && this.month.compareTo(other.month) > 0)
        {
            ret = true;
        }
        else if (this.year == other.year && this.month == other.month && this.day > other.day)
        {
            ret = true;
        }
        return ret;
    }

    // 날짜 비교 (어떤것이 더 작은지)
    public boolean isLowerThan(Date other)
    {
        boolean ret = false;
        if (this.year < other.year)
        {
            ret = true;
        }
        else if (this.year == other.year && this.month.compareTo(other.month) < 0)
        {
            ret = true;
        }
        else if (this.year == other.year && this.month == other.month && this.day < other.day)
        {
            ret = true;
        }
        return ret;
    }

    // 오버라이딩
    // obj를 Date로 바꾸고 비교
    @Override
    public boolean equals(Object obj)
    {
        boolean ret = false;
        if (obj instanceof Date)
        {
            if (this.year == ((Date)obj).year && this.month == ((Date)obj).month
                    && this.day == ((Date)obj).day)
            {
                ret = true;
            }
        }
        return ret;
    }

    // 출력용
    @Override
    public String toString()
    {
        // 자료형 -> 정수형
        int month = this.month.getValue();

        String stringMonth;

        // month가 한 자리수인 경우 앞에 0 붙이기
        if (month < 10)
        {
            stringMonth = new String("0" + month);
        }
        else
        {
            stringMonth = Integer.toString(month);
        }

        String stringDay;

        // Day가 한 자리수인 경우 앞에 0 붙이기
        if (this.day < 10)
        {
            stringDay = new String("0" + this.day);
        }
        else
        {
            stringDay = Integer.toString(this.day);
        }

        return new String(this.year + "-" + stringMonth + "-" + stringDay + "-" + this.dayOfWeek);
    }


}
