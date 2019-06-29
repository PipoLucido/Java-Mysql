/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* @author Emili */
public class MiCalendario extends GregorianCalendar {

    public MiCalendario(int d, int m, int a) throws MiCalendarioException {
        super(a, --m, d);
        if (this.get(Calendar.DAY_OF_MONTH) != d || this.get(Calendar.MONTH) != m || this.get(Calendar.YEAR) != a) {
            throw new MiCalendarioException();
        }
    }

    public MiCalendario(String s) throws MiCalendarioException {
        this(
                Integer.parseInt(s.substring(0, 1)),
                Integer.parseInt(s.substring(3, 4)),
                Integer.parseInt(s.substring(6, 9)));
    }

    public Integer getDay() {
        return this.get(Calendar.DAY_OF_MONTH);
    }

    public Integer getMonth() {
        return this.get(Calendar.MONTH) + 1;
    }

    public Integer getYear() {
        return this.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        String returnval = "";

        if (this.getDay() < 10) returnval += "0";
        returnval = returnval + this.getDay() + "-";
        if (this.getMonth() < 10) returnval += "0";
        returnval = returnval + this.getMonth() + "-";
        returnval = returnval + this.getYear();

        return returnval;
    }
}
