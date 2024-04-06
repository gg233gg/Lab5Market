public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    /**
     * 记录每个月中的天数，需要区分平年和闰年
     */
    static int[][] monthDay = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

    /**
     * 接收一个格式为xxxx/xx/xx字符串日期
     */
    Date(String str) {
        String[] date = str.split("/");
        year = Integer.parseInt(date[0]);
        month = Integer.parseInt(date[1]);
        day = Integer.parseInt(date[2]);
    }

    /**
     * 接受一个格式为xxxx/xx/xx字符串日期，并将其向后调整d天
     */
    Date(String str, int d) {
        this(str);
        this.nextDay(d);
    }

    /**
     * 返回当前月份对应的天数
     */
    public int getMonthDay() {
        int key = 0;
        if (isLeapYear()) key = 1;
        return monthDay[key][month - 1];
    }

    /**
     * 将时间设为下一天
     */
    public void nextDay() {
        day++;
        if (day > getMonthDay()) {
            month++;
            day = 1;
            if (month > 12) {
                year++;
                month = 1;
            }
        }
    }

    /**
     * 将当前日期往后推d天
     */
    public void nextDay(int d) {
        for (int i = 0; i < d; i++) {
            nextDay();
        }
    }

    /**
     * 判断是否是闰年
     */
    public boolean isLeapYear() {
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
    }

    /**
     * 判断两个日期是否是同一天
     */
    public boolean isEqual(final Date date) {
        return (this.year == date.year && this.month == date.month && this.day == date.day);
    }

    public void print() {
        System.out.print(year + "/" + month + "/" + day + "\n");
    }

    /**
     * 比较this和date之间差了多少天，如果this在date之后，返回一个正数
     */
    public int compareTo(Date date) {
        int i = 0;
        Date thisCopy = new Date(this.year + "/" + this.month + "/" + this.day);
        Date dateCopy = new Date(date.year + "/" + date.month + "/" + date.day);
        if (thisCopy.isEqual(dateCopy)) i = 0;
        else {
            if (thisCopy.isLessThan(dateCopy)) {
                while (!thisCopy.isEqual(dateCopy)) {
                    thisCopy.nextDay();
                    i--;
                }
            } else {
                while (!thisCopy.isEqual(dateCopy)) {
                    dateCopy.nextDay();
                    i++;
                }
            }
        }
        return i;
    }


    /**
     * 判断this的日期是否在date之前
     */
    public boolean isLessThan(final Date date) {
        return (year < date.year) ||
                (year == date.year && month < date.month) ||
                (year == date.year && month == date.month && day < date.day);

    }

}