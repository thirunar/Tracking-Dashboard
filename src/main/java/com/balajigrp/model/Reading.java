package com.balajigrp.model;

import com.balajigrp.util.CastUtil;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

import static com.balajigrp.util.CastUtil.getBigDecimal;
import static com.balajigrp.util.CastUtil.getBigInteger;
import static com.balajigrp.util.CastUtil.getString;

@org.springframework.data.elasticsearch.annotations.Document(indexName = "reading", type = "reading", shards = 1, replicas = 0, refreshInterval = "-1")
public class Reading {

    @Id
    private String id;

    private BigDecimal omr;
    private BigDecimal cmr;
    private BigDecimal kilometers;
    private BigDecimal litres;
    private BigDecimal mileage;
    private BigInteger ton;
    private String driverName;
    private String destination;
    private BigDecimal tollFee;
    private BigDecimal tiffinCost;
    private BigDecimal personalCost;
    private BigDecimal unloadingCost;
    private BigDecimal rtoFee;
    private BigDecimal weighBridge;
    private BigDecimal expenses;
    private BigDecimal dieselExpense;
    private BigDecimal totalExpenses;
    private BigDecimal netAmount;
    private BigDecimal rent;
    private String companyName;
    private BigDecimal maintenance;
    private BigDecimal dieselUnitPrice;

    public Reading() {
    }

    public Reading(String id, BigDecimal omr, BigDecimal cmr, BigDecimal litres, BigInteger ton, String driverName, String destination, BigDecimal tollFee, BigDecimal tiffinCost, BigDecimal personalCost, BigDecimal unloadingCost, BigDecimal rtoFee, BigDecimal weighBridge, BigDecimal rent, String companyName, BigDecimal maintenance, BigDecimal dieselPrice) {
        this.id = id;
        this.omr = omr;
        this.cmr = cmr;
        this.kilometers = cmr.subtract(omr);
        this.litres = litres;
        this.ton = ton;
        this.driverName = driverName;
        this.destination = destination;
        this.tollFee = tollFee;
        this.tiffinCost = tiffinCost;
        this.personalCost = personalCost;
        this.unloadingCost = unloadingCost;
        this.rtoFee = rtoFee;
        this.weighBridge = weighBridge;
        this.rent = rent;
        this.companyName = companyName;
        this.maintenance = maintenance;
        this.dieselUnitPrice = dieselPrice;
        this.mileage = cmr.subtract(omr).divide(litres, 2, 1);
        this.expenses = tollFee.add(tiffinCost).add(personalCost).add(unloadingCost).add(rtoFee).add(weighBridge);
        this.dieselExpense = litres.multiply(dieselUnitPrice).setScale(2, 1);
        this.totalExpenses = this.expenses.add(dieselExpense).setScale(2, 1);
        this.netAmount = this.rent.subtract(this.totalExpenses);
    }

    public Reading(BigDecimal omr, BigDecimal cmr, BigDecimal litres, BigInteger ton, String driverName, String destination, BigDecimal tollFee, BigDecimal tiffinCost, BigDecimal personalCost, BigDecimal unloadingCost, BigDecimal rtoFee, BigDecimal weighBridge, BigDecimal rent, String companyName, BigDecimal maintenance, BigDecimal dieselPrice) {
        this.omr = omr;
        this.cmr = cmr;
        this.kilometers = cmr.subtract(omr);
        this.litres = litres;
        this.ton = ton;
        this.driverName = driverName;
        this.destination = destination;
        this.tollFee = tollFee;
        this.tiffinCost = tiffinCost;
        this.personalCost = personalCost;
        this.unloadingCost = unloadingCost;
        this.rtoFee = rtoFee;
        this.weighBridge = weighBridge;
        this.rent = rent;
        this.companyName = companyName;
        this.maintenance = maintenance;
        this.dieselUnitPrice = dieselPrice;
        this.mileage = cmr.subtract(omr).divide(litres, 2, 1);
        this.expenses = tollFee.add(tiffinCost).add(personalCost).add(unloadingCost).add(rtoFee).add(weighBridge);
        this.dieselExpense = litres.multiply(dieselUnitPrice).setScale(2, 1);
        this.totalExpenses = this.expenses.add(dieselExpense).setScale(2, 1);
        this.netAmount = this.rent.subtract(this.totalExpenses);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getOmr() {
        return omr;
    }

    public BigDecimal getCmr() {
        return cmr;
    }

    public BigDecimal getKilometers() {
        return kilometers;
    }

    public BigDecimal getLitres() {
        return litres;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public BigInteger getTon() {
        return ton;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDestination() {
        return destination;
    }

    public BigDecimal getTollFee() {
        return tollFee;
    }

    public BigDecimal getTiffinCost() {
        return tiffinCost;
    }

    public BigDecimal getPersonalCost() {
        return personalCost;
    }

    public BigDecimal getUnloadingCost() {
        return unloadingCost;
    }

    public BigDecimal getRtoFee() {
        return rtoFee;
    }

    public BigDecimal getWeighBridge() {
        return weighBridge;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public BigDecimal getDieselExpense() {
        return dieselExpense;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BigDecimal getMaintenance() {
        return maintenance;
    }

    public BigDecimal getDieselUnitPrice() {
        return dieselUnitPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reading reading = (Reading) o;

        if (id != null ? !id.equals(reading.id) : reading.id != null) return false;
        if (omr != null ? !omr.equals(reading.omr) : reading.omr != null) return false;
        if (cmr != null ? !cmr.equals(reading.cmr) : reading.cmr != null) return false;
        if (kilometers != null ? !kilometers.equals(reading.kilometers) : reading.kilometers != null) return false;
        if (litres != null ? !litres.equals(reading.litres) : reading.litres != null) return false;
        if (mileage != null ? !mileage.equals(reading.mileage) : reading.mileage != null) return false;
        if (ton != null ? !ton.equals(reading.ton) : reading.ton != null) return false;
        if (driverName != null ? !driverName.equals(reading.driverName) : reading.driverName != null) return false;
        if (destination != null ? !destination.equals(reading.destination) : reading.destination != null) return false;
        if (tollFee != null ? !tollFee.equals(reading.tollFee) : reading.tollFee != null) return false;
        if (tiffinCost != null ? !tiffinCost.equals(reading.tiffinCost) : reading.tiffinCost != null) return false;
        if (personalCost != null ? !personalCost.equals(reading.personalCost) : reading.personalCost != null)
            return false;
        if (unloadingCost != null ? !unloadingCost.equals(reading.unloadingCost) : reading.unloadingCost != null)
            return false;
        if (rtoFee != null ? !rtoFee.equals(reading.rtoFee) : reading.rtoFee != null) return false;
        if (weighBridge != null ? !weighBridge.equals(reading.weighBridge) : reading.weighBridge != null) return false;
        if (expenses != null ? !expenses.equals(reading.expenses) : reading.expenses != null) return false;
        if (dieselExpense != null ? !dieselExpense.equals(reading.dieselExpense) : reading.dieselExpense != null)
            return false;
        if (totalExpenses != null ? !totalExpenses.equals(reading.totalExpenses) : reading.totalExpenses != null)
            return false;
        if (netAmount != null ? !netAmount.equals(reading.netAmount) : reading.netAmount != null) return false;
        if (rent != null ? !rent.equals(reading.rent) : reading.rent != null) return false;
        if (companyName != null ? !companyName.equals(reading.companyName) : reading.companyName != null) return false;
        if (maintenance != null ? !maintenance.equals(reading.maintenance) : reading.maintenance != null) return false;
        return dieselUnitPrice != null ? dieselUnitPrice.equals(reading.dieselUnitPrice) : reading.dieselUnitPrice == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (omr != null ? omr.hashCode() : 0);
        result = 31 * result + (cmr != null ? cmr.hashCode() : 0);
        result = 31 * result + (kilometers != null ? kilometers.hashCode() : 0);
        result = 31 * result + (litres != null ? litres.hashCode() : 0);
        result = 31 * result + (mileage != null ? mileage.hashCode() : 0);
        result = 31 * result + (ton != null ? ton.hashCode() : 0);
        result = 31 * result + (driverName != null ? driverName.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (tollFee != null ? tollFee.hashCode() : 0);
        result = 31 * result + (tiffinCost != null ? tiffinCost.hashCode() : 0);
        result = 31 * result + (personalCost != null ? personalCost.hashCode() : 0);
        result = 31 * result + (unloadingCost != null ? unloadingCost.hashCode() : 0);
        result = 31 * result + (rtoFee != null ? rtoFee.hashCode() : 0);
        result = 31 * result + (weighBridge != null ? weighBridge.hashCode() : 0);
        result = 31 * result + (expenses != null ? expenses.hashCode() : 0);
        result = 31 * result + (dieselExpense != null ? dieselExpense.hashCode() : 0);
        result = 31 * result + (totalExpenses != null ? totalExpenses.hashCode() : 0);
        result = 31 * result + (netAmount != null ? netAmount.hashCode() : 0);
        result = 31 * result + (rent != null ? rent.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (maintenance != null ? maintenance.hashCode() : 0);
        result = 31 * result + (dieselUnitPrice != null ? dieselUnitPrice.hashCode() : 0);
        return result;
    }

    public static Reading fromMap(Map<String, Object> map) {
        return new Reading(getBigDecimal(map.get("omr")),
                getBigDecimal(map.get("cmr")),
                getBigDecimal(map.get("litres")),
                getBigInteger(map.get("ton")),
                getString(map.get("driverName")),
                getString(map.get("destination")),
                getBigDecimal(map.get("tollFee")),
                getBigDecimal(map.get("tiffinCost")),
                getBigDecimal(map.get("personalCost")),
                getBigDecimal(map.get("unloadingCost")),
                getBigDecimal(map.get("rtoFee")),
                getBigDecimal(map.get("weighBridge")),
                getBigDecimal(map.get("rent")),
                getString(map.get("companyName")),
                getBigDecimal(map.get("maintenance")),
                getBigDecimal(map.get("dieselPrice")));
    }
}
