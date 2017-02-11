package cn.springmvc.bean;

/**
 * Created by free on 17-2-10.
 * 处理航班信息的代码
 */
public class FlightBean {
    private String m_carrier;
    private int m_number;
    private String m_departure;
    private String m_arrival;

    public FlightBean() {
    }

    public void setCarrier(String carrier) {
        m_carrier = carrier;
    }

    public String getCarrier() {
        return m_carrier;
    }

    public void setNumber(int number) {
        m_number = number;
    }

    public int getNumber() {
        return m_number;
    }

    public void setDepartureTime(String time) {
        m_departure = time;
    }

    public String getDepartureTime() {
        return m_departure;
    }

    public void setArrivalTime(String time) {
        m_arrival = time;
    }

    public String getArrivalTime() {
        return m_arrival;
    }
}
