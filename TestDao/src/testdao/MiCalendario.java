/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* @author Emili */
public class MiCalendario extends GregorianCalendar{
    public MiCalendario(int d, int m, int a) throws MiCalendarioException
    {
        super(a, --m, d);
        if (this.get(Calendar.DAY_OF_MONTH) != d || this.get(Calendar.MONTH) != m || this.get(Calendar.YEAR) != a)
            throw new MiCalendarioException();
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
        return
            this.getDay().toString() + "-" +
            this.getMonth().toString() + "-" +
            this.getYear().toString();
    }
}