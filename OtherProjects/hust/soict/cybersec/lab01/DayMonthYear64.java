package hust.soict.cybersec.lab01;

import javax.swing.JOptionPane;

public class DayMonthYear64 {
    public static int getMonth(String a){
        switch (a) {
            case "January": case "Jan": case "Jan.": case "1": return 1;
            case "February": case "Feb": case "Feb.": case "2": return 2;
            case "March": case "Mar": case "Mar.": case "3": return 3;
            case "April": case "Apr": case "Apr.": case "4": return 4;
            case "May": case "5": return 5;
            case "June": case "Jun": case "6": return 6;
            case "July": case "Jul": case "7": return 7;
            case "August": case "Aug": case "Aug.": case "8": return 8;
            case "September": case "Sep": case "Sep.": case "9": return 9;
            case "October": case "Oct": case "Oct.": case "10": return 10;
            case "November": case "Nov": case "Nov.": case "11": return 11;
            case "December": case "Dec": case "Dec.": case "12": return 12;
            default: return -1; // Tháng không hợp lệ
        }
    }

    public static int getYear(String b){
        int Year = Integer.parseInt(b); //Chuyen thanh so nhu yeu cau de bai
        if(Year >= 0)
            return Year;
        else return -1;
    }

    public static int getDaysinnMonth(int a, int b){
        switch (a){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 4: case 6: case 9: case 11: return 30;
            case 2:
                return LeapYear(b);
            default: return 0;
        }
    }

    public static int LeapYear(int year){
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) == true) return 29;
        else return 28;
    }


    public static void main(String[] args) {
        while(true) { //lap vo han
            String InputMonth = JOptionPane.showInputDialog("Nhap thang");
            String InputYear = JOptionPane.showInputDialog("Nhap nam");

            int Month = getMonth(InputMonth);
            int Year = getYear(InputYear);

            if ((Month == -1 || Year == -1)) {
                JOptionPane.showMessageDialog(null, "Sai roi nhap lai de");
                continue;
            }
            int days = getDaysinnMonth(Month, Year);
            JOptionPane.showMessageDialog(null, "So ngay trong thang la " + days);
            break;
        }
    }
}
