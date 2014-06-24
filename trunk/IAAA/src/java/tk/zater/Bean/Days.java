/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tk.zater.Bean;

import java.util.ArrayList;
import java.util.List;
import tk.zater.CS.FoodTable;
import tk.zater.CS.HotelTable;
import tk.zater.CS.LocationTable;
import tk.zater.CS.MemoTable;
import tk.zater.CS.PointTable;

/**
 *
 * @author zater
 */
public class Days {
        List<PointTable> point=new ArrayList<PointTable>();
           List<FoodTable>food=new ArrayList<FoodTable>();
           List<HotelTable>hotel=new ArrayList<HotelTable>();
           List<LocationTable>location=new ArrayList<LocationTable>();
           List<MemoTable>memo=new ArrayList<>();
           int day;

    public Days() {
    }

    public List<PointTable> getPoint() {
        return point;
    }

    public void setPoint(List<PointTable> point) {
        this.point = point;
    }

    public List<FoodTable> getFood() {
        return food;
    }

    public void setFood(List<FoodTable> food) {
        this.food = food;
    }

    public List<HotelTable> getHotel() {
        return hotel;
    }

    public void setHotel(List<HotelTable> hotel) {
        this.hotel = hotel;
    }

    public List<LocationTable> getLocation() {
        return location;
    }

    public void setLocation(List<LocationTable> location) {
        this.location = location;
    }

    public List<MemoTable> getMemo() {
        return memo;
    }

    public void setMemo(List<MemoTable> memo) {
        this.memo = memo;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
           
           
           
}
