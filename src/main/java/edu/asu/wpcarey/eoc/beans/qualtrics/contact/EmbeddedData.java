
package edu.asu.wpcarey.eoc.beans.qualtrics.contact;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Organization",
    "arizona_Q1A1",
    "california_Q1A1",
    "colorado_Q1A1",
    "idaho_Q1A1",
    "montana_Q1A1",
    "nevada_Q1A1",
    "new mexico_Q1A1",
    "oregon_Q1A1",
    "texas_Q1A1",
    "utah_Q1A1",
    "washington_Q1A1",
    "wyoming_Q1A1",
    "arizona_Q2A1_ggr",
    "california_Q2A1_ggr",
    "colorado_Q2A1_ggr",
    "idaho_Q2A1_ggr",
    "montana_Q2A1_ggr",
    "nevada_Q2A1_ggr",
    "new mexico_Q2A1_ggr",
    "oregon_Q2A1_ggr",
    "texas_Q2A1_ggr",
    "utah_Q2A1_ggr",
    "washington_Q2A1_ggr",
    "wyoming_Q2A1_ggr",
    "arizona_Q4A1",
    "california_Q4A1",
    "colorado_Q4A1",
    "idaho_Q4A1",
    "montana_Q4A1",
    "nevada_Q4A1",
    "new mexico_Q4A1",
    "oregon_Q4A1",
    "texas_Q4A1",
    "utah_Q4A1",
    "washington_Q4A1",
    "wyoming_Q4A1",
    "arizona_Q2A1",
    "california_Q2A1",
    "colorado_Q2A1",
    "idaho_Q2A1",
    "montana_Q2A1",
    "nevada_Q2A1",
    "new mexico_Q2A1",
    "oregon_Q2A1",
    "texas_Q2A1",
    "utah_Q2A1",
    "washington_Q2A1",
    "wyoming_Q2A1",
    "arizona_Q5A1",
    "california_Q5A1",
    "colorado_Q5A1",
    "idaho_Q5A1",
    "montana_Q5A1",
    "nevada_Q5A1",
    "new mexico_Q5A1",
    "oregon_Q5A1",
    "texas_Q5A1",
    "utah_Q5A1",
    "washington_Q5A1",
    "wyoming_Q5A1",
    "arizona_Q3A1",
    "california_Q3A1",
    "colorado_Q3A1",
    "idaho_Q3A1",
    "montana_Q3A1",
    "nevada_Q3A1",
    "new mexico_Q3A1",
    "oregon_Q3A1",
    "texas_Q3A1",
    "utah_Q3A1",
    "washington_Q3A1",
    "wyoming_Q3A1",
    "arizona_Q1A2",
    "california_Q1A2",
    "colorado_Q1A2",
    "idaho_Q1A2",
    "montana_Q1A2",
    "nevada_Q1A2",
    "new mexico_Q1A2",
    "oregon_Q1A2",
    "texas_Q1A2",
    "utah_Q1A2",
    "washington_Q1A2",
    "wyoming_Q1A2",
    "arizona_Q2A2_ggr",
    "california_Q2A2_ggr",
    "colorado_Q2A2_ggr",
    "idaho_Q2A2_ggr",
    "montana_Q2A2_ggr",
    "nevada_Q2A2_ggr",
    "new mexico_Q2A2_ggr",
    "oregon_Q2A2_ggr",
    "texas_Q2A2_ggr",
    "utah_Q2A2_ggr",
    "washington_Q2A2_ggr",
    "wyoming_Q2A2_ggr",
    "arizona_Q4A2",
    "california_Q4A2",
    "colorado_Q4A2",
    "idaho_Q4A2",
    "montana_Q4A2",
    "nevada_Q4A2",
    "new mexico_Q4A2",
    "oregon_Q4A2",
    "texas_Q4A2",
    "utah_Q4A2",
    "washington_Q4A2",
    "wyoming_Q4A2",
    "arizona_Q2A2",
    "california_Q2A2",
    "colorado_Q2A2",
    "idaho_Q2A2",
    "montana_Q2A2",
    "nevada_Q2A2",
    "new mexico_Q2A2",
    "oregon_Q2A2",
    "texas_Q2A2",
    "utah_Q2A2",
    "washington_Q2A2",
    "wyoming_Q2A2",
    "arizona_Q5A2",
    "california_Q5A2",
    "colorado_Q5A2",
    "idaho_Q5A2",
    "montana_Q5A2",
    "nevada_Q5A2",
    "new mexico_Q5A2",
    "oregon_Q5A2",
    "texas_Q5A2",
    "utah_Q5A2",
    "washington_Q5A2",
    "wyoming_Q5A2",
    "arizona_Q3A2",
    "california_Q3A2",
    "colorado_Q3A2",
    "idaho_Q3A2",
    "montana_Q3A2",
    "nevada_Q3A2",
    "new mexico_Q3A2",
    "oregon_Q3A2",
    "texas_Q3A2",
    "utah_Q3A2",
    "washington_Q3A2",
    "wyoming_Q3A2",
    "arizona_Q2A1_mfg",
    "california_Q2A1_mfg",
    "colorado_Q2A1_mfg",
    "idaho_Q2A1_mfg",
    "montana_Q2A1_mfg",
    "nevada_Q2A1_mfg",
    "new mexico_Q2A1_mfg",
    "oregon_Q2A1_mfg",
    "texas_Q2A1_mfg",
    "utah_Q2A1_mfg",
    "washington_Q2A1_mfg",
    "wyoming_Q2A1_mfg",
    "arizona_Q2A2_mfg",
    "california_Q2A2_mfg",
    "colorado_Q2A2_mfg",
    "idaho_Q2A2_mfg",
    "montana_Q2A2_mfg",
    "nevada_Q2A2_mfg",
    "new mexico_Q2A2_mfg",
    "oregon_Q2A2_mfg",
    "texas_Q2A2_mfg",
    "utah_Q2A2_mfg",
    "washington_Q2A2_mfg",
    "wyoming_Q2A2_mfg",
    "datearizona",
    "datecalifornia",
    "datecolorado",
    "dateidaho",
    "datemontana",
    "datenevada",
    "datenew mexico",
    "dateoregon",
    "datetexas",
    "dateutah",
    "datewashington",
    "datewyoming",
    "arizona",
    "california",
    "colorado",
    "idaho",
    "montana",
    "nevada",
    "new_mexico",
    "oregon",
    "texas",
    "utah",
    "washington",
    "wyoming",
    "id",
    "Name"
})
public class EmbeddedData {

    @JsonProperty("Organization")
    private String organization;
    @JsonProperty("arizona_Q1A1")
    private String arizonaQ1A1;
    @JsonProperty("california_Q1A1")
    private String californiaQ1A1;
    @JsonProperty("colorado_Q1A1")
    private String coloradoQ1A1;
    @JsonProperty("idaho_Q1A1")
    private String idahoQ1A1;
    @JsonProperty("montana_Q1A1")
    private String montanaQ1A1;
    @JsonProperty("nevada_Q1A1")
    private String nevadaQ1A1;
    @JsonProperty("new mexico_Q1A1")
    private String newMexicoQ1A1;
    @JsonProperty("oregon_Q1A1")
    private String oregonQ1A1;
    @JsonProperty("texas_Q1A1")
    private String texasQ1A1;
    @JsonProperty("utah_Q1A1")
    private String utahQ1A1;
    @JsonProperty("washington_Q1A1")
    private String washingtonQ1A1;
    @JsonProperty("wyoming_Q1A1")
    private String wyomingQ1A1;
    @JsonProperty("arizona_Q2A1_ggr")
    private String arizonaQ2A1Ggr;
    @JsonProperty("california_Q2A1_ggr")
    private String californiaQ2A1Ggr;
    @JsonProperty("colorado_Q2A1_ggr")
    private String coloradoQ2A1Ggr;
    @JsonProperty("idaho_Q2A1_ggr")
    private String idahoQ2A1Ggr;
    @JsonProperty("montana_Q2A1_ggr")
    private String montanaQ2A1Ggr;
    @JsonProperty("nevada_Q2A1_ggr")
    private String nevadaQ2A1Ggr;
    @JsonProperty("new mexico_Q2A1_ggr")
    private String newMexicoQ2A1Ggr;
    @JsonProperty("oregon_Q2A1_ggr")
    private String oregonQ2A1Ggr;
    @JsonProperty("texas_Q2A1_ggr")
    private String texasQ2A1Ggr;
    @JsonProperty("utah_Q2A1_ggr")
    private String utahQ2A1Ggr;
    @JsonProperty("washington_Q2A1_ggr")
    private String washingtonQ2A1Ggr;
    @JsonProperty("wyoming_Q2A1_ggr")
    private String wyomingQ2A1Ggr;
    @JsonProperty("arizona_Q4A1")
    private String arizonaQ4A1;
    @JsonProperty("california_Q4A1")
    private String californiaQ4A1;
    @JsonProperty("colorado_Q4A1")
    private String coloradoQ4A1;
    @JsonProperty("idaho_Q4A1")
    private String idahoQ4A1;
    @JsonProperty("montana_Q4A1")
    private String montanaQ4A1;
    @JsonProperty("nevada_Q4A1")
    private String nevadaQ4A1;
    @JsonProperty("new mexico_Q4A1")
    private String newMexicoQ4A1;
    @JsonProperty("oregon_Q4A1")
    private String oregonQ4A1;
    @JsonProperty("texas_Q4A1")
    private String texasQ4A1;
    @JsonProperty("utah_Q4A1")
    private String utahQ4A1;
    @JsonProperty("washington_Q4A1")
    private String washingtonQ4A1;
    @JsonProperty("wyoming_Q4A1")
    private String wyomingQ4A1;
    @JsonProperty("arizona_Q2A1")
    private String arizonaQ2A1;
    @JsonProperty("california_Q2A1")
    private String californiaQ2A1;
    @JsonProperty("colorado_Q2A1")
    private String coloradoQ2A1;
    @JsonProperty("idaho_Q2A1")
    private String idahoQ2A1;
    @JsonProperty("montana_Q2A1")
    private String montanaQ2A1;
    @JsonProperty("nevada_Q2A1")
    private String nevadaQ2A1;
    @JsonProperty("new mexico_Q2A1")
    private String newMexicoQ2A1;
    @JsonProperty("oregon_Q2A1")
    private String oregonQ2A1;
    @JsonProperty("texas_Q2A1")
    private String texasQ2A1;
    @JsonProperty("utah_Q2A1")
    private String utahQ2A1;
    @JsonProperty("washington_Q2A1")
    private String washingtonQ2A1;
    @JsonProperty("wyoming_Q2A1")
    private String wyomingQ2A1;
    @JsonProperty("arizona_Q5A1")
    private String arizonaQ5A1;
    @JsonProperty("california_Q5A1")
    private String californiaQ5A1;
    @JsonProperty("colorado_Q5A1")
    private String coloradoQ5A1;
    @JsonProperty("idaho_Q5A1")
    private String idahoQ5A1;
    @JsonProperty("montana_Q5A1")
    private String montanaQ5A1;
    @JsonProperty("nevada_Q5A1")
    private String nevadaQ5A1;
    @JsonProperty("new mexico_Q5A1")
    private String newMexicoQ5A1;
    @JsonProperty("oregon_Q5A1")
    private String oregonQ5A1;
    @JsonProperty("texas_Q5A1")
    private String texasQ5A1;
    @JsonProperty("utah_Q5A1")
    private String utahQ5A1;
    @JsonProperty("washington_Q5A1")
    private String washingtonQ5A1;
    @JsonProperty("wyoming_Q5A1")
    private String wyomingQ5A1;
    @JsonProperty("arizona_Q3A1")
    private String arizonaQ3A1;
    @JsonProperty("california_Q3A1")
    private String californiaQ3A1;
    @JsonProperty("colorado_Q3A1")
    private String coloradoQ3A1;
    @JsonProperty("idaho_Q3A1")
    private String idahoQ3A1;
    @JsonProperty("montana_Q3A1")
    private String montanaQ3A1;
    @JsonProperty("nevada_Q3A1")
    private String nevadaQ3A1;
    @JsonProperty("new mexico_Q3A1")
    private String newMexicoQ3A1;
    @JsonProperty("oregon_Q3A1")
    private String oregonQ3A1;
    @JsonProperty("texas_Q3A1")
    private String texasQ3A1;
    @JsonProperty("utah_Q3A1")
    private String utahQ3A1;
    @JsonProperty("washington_Q3A1")
    private String washingtonQ3A1;
    @JsonProperty("wyoming_Q3A1")
    private String wyomingQ3A1;
    @JsonProperty("arizona_Q1A2")
    private String arizonaQ1A2;
    @JsonProperty("california_Q1A2")
    private String californiaQ1A2;
    @JsonProperty("colorado_Q1A2")
    private String coloradoQ1A2;
    @JsonProperty("idaho_Q1A2")
    private String idahoQ1A2;
    @JsonProperty("montana_Q1A2")
    private String montanaQ1A2;
    @JsonProperty("nevada_Q1A2")
    private String nevadaQ1A2;
    @JsonProperty("new mexico_Q1A2")
    private String newMexicoQ1A2;
    @JsonProperty("oregon_Q1A2")
    private String oregonQ1A2;
    @JsonProperty("texas_Q1A2")
    private String texasQ1A2;
    @JsonProperty("utah_Q1A2")
    private String utahQ1A2;
    @JsonProperty("washington_Q1A2")
    private String washingtonQ1A2;
    @JsonProperty("wyoming_Q1A2")
    private String wyomingQ1A2;
    @JsonProperty("arizona_Q2A2_ggr")
    private String arizonaQ2A2Ggr;
    @JsonProperty("california_Q2A2_ggr")
    private String californiaQ2A2Ggr;
    @JsonProperty("colorado_Q2A2_ggr")
    private String coloradoQ2A2Ggr;
    @JsonProperty("idaho_Q2A2_ggr")
    private String idahoQ2A2Ggr;
    @JsonProperty("montana_Q2A2_ggr")
    private String montanaQ2A2Ggr;
    @JsonProperty("nevada_Q2A2_ggr")
    private String nevadaQ2A2Ggr;
    @JsonProperty("new mexico_Q2A2_ggr")
    private String newMexicoQ2A2Ggr;
    @JsonProperty("oregon_Q2A2_ggr")
    private String oregonQ2A2Ggr;
    @JsonProperty("texas_Q2A2_ggr")
    private String texasQ2A2Ggr;
    @JsonProperty("utah_Q2A2_ggr")
    private String utahQ2A2Ggr;
    @JsonProperty("washington_Q2A2_ggr")
    private String washingtonQ2A2Ggr;
    @JsonProperty("wyoming_Q2A2_ggr")
    private String wyomingQ2A2Ggr;
    @JsonProperty("arizona_Q4A2")
    private String arizonaQ4A2;
    @JsonProperty("california_Q4A2")
    private String californiaQ4A2;
    @JsonProperty("colorado_Q4A2")
    private String coloradoQ4A2;
    @JsonProperty("idaho_Q4A2")
    private String idahoQ4A2;
    @JsonProperty("montana_Q4A2")
    private String montanaQ4A2;
    @JsonProperty("nevada_Q4A2")
    private String nevadaQ4A2;
    @JsonProperty("new mexico_Q4A2")
    private String newMexicoQ4A2;
    @JsonProperty("oregon_Q4A2")
    private String oregonQ4A2;
    @JsonProperty("texas_Q4A2")
    private String texasQ4A2;
    @JsonProperty("utah_Q4A2")
    private String utahQ4A2;
    @JsonProperty("washington_Q4A2")
    private String washingtonQ4A2;
    @JsonProperty("wyoming_Q4A2")
    private String wyomingQ4A2;
    @JsonProperty("arizona_Q2A2")
    private String arizonaQ2A2;
    @JsonProperty("california_Q2A2")
    private String californiaQ2A2;
    @JsonProperty("colorado_Q2A2")
    private String coloradoQ2A2;
    @JsonProperty("idaho_Q2A2")
    private String idahoQ2A2;
    @JsonProperty("montana_Q2A2")
    private String montanaQ2A2;
    @JsonProperty("nevada_Q2A2")
    private String nevadaQ2A2;
    @JsonProperty("new mexico_Q2A2")
    private String newMexicoQ2A2;
    @JsonProperty("oregon_Q2A2")
    private String oregonQ2A2;
    @JsonProperty("texas_Q2A2")
    private String texasQ2A2;
    @JsonProperty("utah_Q2A2")
    private String utahQ2A2;
    @JsonProperty("washington_Q2A2")
    private String washingtonQ2A2;
    @JsonProperty("wyoming_Q2A2")
    private String wyomingQ2A2;
    @JsonProperty("arizona_Q5A2")
    private String arizonaQ5A2;
    @JsonProperty("california_Q5A2")
    private String californiaQ5A2;
    @JsonProperty("colorado_Q5A2")
    private String coloradoQ5A2;
    @JsonProperty("idaho_Q5A2")
    private String idahoQ5A2;
    @JsonProperty("montana_Q5A2")
    private String montanaQ5A2;
    @JsonProperty("nevada_Q5A2")
    private String nevadaQ5A2;
    @JsonProperty("new mexico_Q5A2")
    private String newMexicoQ5A2;
    @JsonProperty("oregon_Q5A2")
    private String oregonQ5A2;
    @JsonProperty("texas_Q5A2")
    private String texasQ5A2;
    @JsonProperty("utah_Q5A2")
    private String utahQ5A2;
    @JsonProperty("washington_Q5A2")
    private String washingtonQ5A2;
    @JsonProperty("wyoming_Q5A2")
    private String wyomingQ5A2;
    @JsonProperty("arizona_Q3A2")
    private String arizonaQ3A2;
    @JsonProperty("california_Q3A2")
    private String californiaQ3A2;
    @JsonProperty("colorado_Q3A2")
    private String coloradoQ3A2;
    @JsonProperty("idaho_Q3A2")
    private String idahoQ3A2;
    @JsonProperty("montana_Q3A2")
    private String montanaQ3A2;
    @JsonProperty("nevada_Q3A2")
    private String nevadaQ3A2;
    @JsonProperty("new mexico_Q3A2")
    private String newMexicoQ3A2;
    @JsonProperty("oregon_Q3A2")
    private String oregonQ3A2;
    @JsonProperty("texas_Q3A2")
    private String texasQ3A2;
    @JsonProperty("utah_Q3A2")
    private String utahQ3A2;
    @JsonProperty("washington_Q3A2")
    private String washingtonQ3A2;
    @JsonProperty("wyoming_Q3A2")
    private String wyomingQ3A2;
    @JsonProperty("arizona_Q2A1_mfg")
    private String arizonaQ2A1Mfg;
    @JsonProperty("california_Q2A1_mfg")
    private String californiaQ2A1Mfg;
    @JsonProperty("colorado_Q2A1_mfg")
    private String coloradoQ2A1Mfg;
    @JsonProperty("idaho_Q2A1_mfg")
    private String idahoQ2A1Mfg;
    @JsonProperty("montana_Q2A1_mfg")
    private String montanaQ2A1Mfg;
    @JsonProperty("nevada_Q2A1_mfg")
    private String nevadaQ2A1Mfg;
    @JsonProperty("new mexico_Q2A1_mfg")
    private String newMexicoQ2A1Mfg;
    @JsonProperty("oregon_Q2A1_mfg")
    private String oregonQ2A1Mfg;
    @JsonProperty("texas_Q2A1_mfg")
    private String texasQ2A1Mfg;
    @JsonProperty("utah_Q2A1_mfg")
    private String utahQ2A1Mfg;
    @JsonProperty("washington_Q2A1_mfg")
    private String washingtonQ2A1Mfg;
    @JsonProperty("wyoming_Q2A1_mfg")
    private String wyomingQ2A1Mfg;
    @JsonProperty("arizona_Q2A2_mfg")
    private String arizonaQ2A2Mfg;
    @JsonProperty("california_Q2A2_mfg")
    private String californiaQ2A2Mfg;
    @JsonProperty("colorado_Q2A2_mfg")
    private String coloradoQ2A2Mfg;
    @JsonProperty("idaho_Q2A2_mfg")
    private String idahoQ2A2Mfg;
    @JsonProperty("montana_Q2A2_mfg")
    private String montanaQ2A2Mfg;
    @JsonProperty("nevada_Q2A2_mfg")
    private String nevadaQ2A2Mfg;
    @JsonProperty("new mexico_Q2A2_mfg")
    private String newMexicoQ2A2Mfg;
    @JsonProperty("oregon_Q2A2_mfg")
    private String oregonQ2A2Mfg;
    @JsonProperty("texas_Q2A2_mfg")
    private String texasQ2A2Mfg;
    @JsonProperty("utah_Q2A2_mfg")
    private String utahQ2A2Mfg;
    @JsonProperty("washington_Q2A2_mfg")
    private String washingtonQ2A2Mfg;
    @JsonProperty("wyoming_Q2A2_mfg")
    private String wyomingQ2A2Mfg;
    @JsonProperty("datearizona")
    private String datearizona;
    @JsonProperty("datecalifornia")
    private String datecalifornia;
    @JsonProperty("datecolorado")
    private String datecolorado;
    @JsonProperty("dateidaho")
    private String dateidaho;
    @JsonProperty("datemontana")
    private String datemontana;
    @JsonProperty("datenevada")
    private String datenevada;
    @JsonProperty("datenew mexico")
    private String datenewMexico;
    @JsonProperty("dateoregon")
    private String dateoregon;
    @JsonProperty("datetexas")
    private String datetexas;
    @JsonProperty("dateutah")
    private String dateutah;
    @JsonProperty("datewashington")
    private String datewashington;
    @JsonProperty("datewyoming")
    private String datewyoming;
    @JsonProperty("arizona")
    private String arizona;
    @JsonProperty("california")
    private String california;
    @JsonProperty("colorado")
    private String colorado;
    @JsonProperty("idaho")
    private String idaho;
    @JsonProperty("montana")
    private String montana;
    @JsonProperty("nevada")
    private String nevada;
    @JsonProperty("new_mexico")
    private String newMexico;
    @JsonProperty("oregon")
    private String oregon;
    @JsonProperty("texas")
    private String texas;
    @JsonProperty("utah")
    private String utah;
    @JsonProperty("washington")
    private String washington;
    @JsonProperty("wyoming")
    private String wyoming;
    @JsonProperty("id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Organization")
    public String getOrganization() {
        return organization;
    }

    @JsonProperty("Organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonProperty("arizona_Q1A1")
    public String getArizonaQ1A1() {
        return arizonaQ1A1;
    }

    @JsonProperty("arizona_Q1A1")
    public void setArizonaQ1A1(String arizonaQ1A1) {
        this.arizonaQ1A1 = arizonaQ1A1;
    }

    @JsonProperty("california_Q1A1")
    public String getCaliforniaQ1A1() {
        return californiaQ1A1;
    }

    @JsonProperty("california_Q1A1")
    public void setCaliforniaQ1A1(String californiaQ1A1) {
        this.californiaQ1A1 = californiaQ1A1;
    }

    @JsonProperty("colorado_Q1A1")
    public String getColoradoQ1A1() {
        return coloradoQ1A1;
    }

    @JsonProperty("colorado_Q1A1")
    public void setColoradoQ1A1(String coloradoQ1A1) {
        this.coloradoQ1A1 = coloradoQ1A1;
    }

    @JsonProperty("idaho_Q1A1")
    public String getIdahoQ1A1() {
        return idahoQ1A1;
    }

    @JsonProperty("idaho_Q1A1")
    public void setIdahoQ1A1(String idahoQ1A1) {
        this.idahoQ1A1 = idahoQ1A1;
    }

    @JsonProperty("montana_Q1A1")
    public String getMontanaQ1A1() {
        return montanaQ1A1;
    }

    @JsonProperty("montana_Q1A1")
    public void setMontanaQ1A1(String montanaQ1A1) {
        this.montanaQ1A1 = montanaQ1A1;
    }

    @JsonProperty("nevada_Q1A1")
    public String getNevadaQ1A1() {
        return nevadaQ1A1;
    }

    @JsonProperty("nevada_Q1A1")
    public void setNevadaQ1A1(String nevadaQ1A1) {
        this.nevadaQ1A1 = nevadaQ1A1;
    }

    @JsonProperty("new mexico_Q1A1")
    public String getNewMexicoQ1A1() {
        return newMexicoQ1A1;
    }

    @JsonProperty("new mexico_Q1A1")
    public void setNewMexicoQ1A1(String newMexicoQ1A1) {
        this.newMexicoQ1A1 = newMexicoQ1A1;
    }

    @JsonProperty("oregon_Q1A1")
    public String getOregonQ1A1() {
        return oregonQ1A1;
    }

    @JsonProperty("oregon_Q1A1")
    public void setOregonQ1A1(String oregonQ1A1) {
        this.oregonQ1A1 = oregonQ1A1;
    }

    @JsonProperty("texas_Q1A1")
    public String getTexasQ1A1() {
        return texasQ1A1;
    }

    @JsonProperty("texas_Q1A1")
    public void setTexasQ1A1(String texasQ1A1) {
        this.texasQ1A1 = texasQ1A1;
    }

    @JsonProperty("utah_Q1A1")
    public String getUtahQ1A1() {
        return utahQ1A1;
    }

    @JsonProperty("utah_Q1A1")
    public void setUtahQ1A1(String utahQ1A1) {
        this.utahQ1A1 = utahQ1A1;
    }

    @JsonProperty("washington_Q1A1")
    public String getWashingtonQ1A1() {
        return washingtonQ1A1;
    }

    @JsonProperty("washington_Q1A1")
    public void setWashingtonQ1A1(String washingtonQ1A1) {
        this.washingtonQ1A1 = washingtonQ1A1;
    }

    @JsonProperty("wyoming_Q1A1")
    public String getWyomingQ1A1() {
        return wyomingQ1A1;
    }

    @JsonProperty("wyoming_Q1A1")
    public void setWyomingQ1A1(String wyomingQ1A1) {
        this.wyomingQ1A1 = wyomingQ1A1;
    }

    @JsonProperty("arizona_Q2A1_ggr")
    public String getArizonaQ2A1Ggr() {
        return arizonaQ2A1Ggr;
    }

    @JsonProperty("arizona_Q2A1_ggr")
    public void setArizonaQ2A1Ggr(String arizonaQ2A1Ggr) {
        this.arizonaQ2A1Ggr = arizonaQ2A1Ggr;
    }

    @JsonProperty("california_Q2A1_ggr")
    public String getCaliforniaQ2A1Ggr() {
        return californiaQ2A1Ggr;
    }

    @JsonProperty("california_Q2A1_ggr")
    public void setCaliforniaQ2A1Ggr(String californiaQ2A1Ggr) {
        this.californiaQ2A1Ggr = californiaQ2A1Ggr;
    }

    @JsonProperty("colorado_Q2A1_ggr")
    public String getColoradoQ2A1Ggr() {
        return coloradoQ2A1Ggr;
    }

    @JsonProperty("colorado_Q2A1_ggr")
    public void setColoradoQ2A1Ggr(String coloradoQ2A1Ggr) {
        this.coloradoQ2A1Ggr = coloradoQ2A1Ggr;
    }

    @JsonProperty("idaho_Q2A1_ggr")
    public String getIdahoQ2A1Ggr() {
        return idahoQ2A1Ggr;
    }

    @JsonProperty("idaho_Q2A1_ggr")
    public void setIdahoQ2A1Ggr(String idahoQ2A1Ggr) {
        this.idahoQ2A1Ggr = idahoQ2A1Ggr;
    }

    @JsonProperty("montana_Q2A1_ggr")
    public String getMontanaQ2A1Ggr() {
        return montanaQ2A1Ggr;
    }

    @JsonProperty("montana_Q2A1_ggr")
    public void setMontanaQ2A1Ggr(String montanaQ2A1Ggr) {
        this.montanaQ2A1Ggr = montanaQ2A1Ggr;
    }

    @JsonProperty("nevada_Q2A1_ggr")
    public String getNevadaQ2A1Ggr() {
        return nevadaQ2A1Ggr;
    }

    @JsonProperty("nevada_Q2A1_ggr")
    public void setNevadaQ2A1Ggr(String nevadaQ2A1Ggr) {
        this.nevadaQ2A1Ggr = nevadaQ2A1Ggr;
    }

    @JsonProperty("new mexico_Q2A1_ggr")
    public String getNewMexicoQ2A1Ggr() {
        return newMexicoQ2A1Ggr;
    }

    @JsonProperty("new mexico_Q2A1_ggr")
    public void setNewMexicoQ2A1Ggr(String newMexicoQ2A1Ggr) {
        this.newMexicoQ2A1Ggr = newMexicoQ2A1Ggr;
    }

    @JsonProperty("oregon_Q2A1_ggr")
    public String getOregonQ2A1Ggr() {
        return oregonQ2A1Ggr;
    }

    @JsonProperty("oregon_Q2A1_ggr")
    public void setOregonQ2A1Ggr(String oregonQ2A1Ggr) {
        this.oregonQ2A1Ggr = oregonQ2A1Ggr;
    }

    @JsonProperty("texas_Q2A1_ggr")
    public String getTexasQ2A1Ggr() {
        return texasQ2A1Ggr;
    }

    @JsonProperty("texas_Q2A1_ggr")
    public void setTexasQ2A1Ggr(String texasQ2A1Ggr) {
        this.texasQ2A1Ggr = texasQ2A1Ggr;
    }

    @JsonProperty("utah_Q2A1_ggr")
    public String getUtahQ2A1Ggr() {
        return utahQ2A1Ggr;
    }

    @JsonProperty("utah_Q2A1_ggr")
    public void setUtahQ2A1Ggr(String utahQ2A1Ggr) {
        this.utahQ2A1Ggr = utahQ2A1Ggr;
    }

    @JsonProperty("washington_Q2A1_ggr")
    public String getWashingtonQ2A1Ggr() {
        return washingtonQ2A1Ggr;
    }

    @JsonProperty("washington_Q2A1_ggr")
    public void setWashingtonQ2A1Ggr(String washingtonQ2A1Ggr) {
        this.washingtonQ2A1Ggr = washingtonQ2A1Ggr;
    }

    @JsonProperty("wyoming_Q2A1_ggr")
    public String getWyomingQ2A1Ggr() {
        return wyomingQ2A1Ggr;
    }

    @JsonProperty("wyoming_Q2A1_ggr")
    public void setWyomingQ2A1Ggr(String wyomingQ2A1Ggr) {
        this.wyomingQ2A1Ggr = wyomingQ2A1Ggr;
    }

    @JsonProperty("arizona_Q4A1")
    public String getArizonaQ4A1() {
        return arizonaQ4A1;
    }

    @JsonProperty("arizona_Q4A1")
    public void setArizonaQ4A1(String arizonaQ4A1) {
        this.arizonaQ4A1 = arizonaQ4A1;
    }

    @JsonProperty("california_Q4A1")
    public String getCaliforniaQ4A1() {
        return californiaQ4A1;
    }

    @JsonProperty("california_Q4A1")
    public void setCaliforniaQ4A1(String californiaQ4A1) {
        this.californiaQ4A1 = californiaQ4A1;
    }

    @JsonProperty("colorado_Q4A1")
    public String getColoradoQ4A1() {
        return coloradoQ4A1;
    }

    @JsonProperty("colorado_Q4A1")
    public void setColoradoQ4A1(String coloradoQ4A1) {
        this.coloradoQ4A1 = coloradoQ4A1;
    }

    @JsonProperty("idaho_Q4A1")
    public String getIdahoQ4A1() {
        return idahoQ4A1;
    }

    @JsonProperty("idaho_Q4A1")
    public void setIdahoQ4A1(String idahoQ4A1) {
        this.idahoQ4A1 = idahoQ4A1;
    }

    @JsonProperty("montana_Q4A1")
    public String getMontanaQ4A1() {
        return montanaQ4A1;
    }

    @JsonProperty("montana_Q4A1")
    public void setMontanaQ4A1(String montanaQ4A1) {
        this.montanaQ4A1 = montanaQ4A1;
    }

    @JsonProperty("nevada_Q4A1")
    public String getNevadaQ4A1() {
        return nevadaQ4A1;
    }

    @JsonProperty("nevada_Q4A1")
    public void setNevadaQ4A1(String nevadaQ4A1) {
        this.nevadaQ4A1 = nevadaQ4A1;
    }

    @JsonProperty("new mexico_Q4A1")
    public String getNewMexicoQ4A1() {
        return newMexicoQ4A1;
    }

    @JsonProperty("new mexico_Q4A1")
    public void setNewMexicoQ4A1(String newMexicoQ4A1) {
        this.newMexicoQ4A1 = newMexicoQ4A1;
    }

    @JsonProperty("oregon_Q4A1")
    public String getOregonQ4A1() {
        return oregonQ4A1;
    }

    @JsonProperty("oregon_Q4A1")
    public void setOregonQ4A1(String oregonQ4A1) {
        this.oregonQ4A1 = oregonQ4A1;
    }

    @JsonProperty("texas_Q4A1")
    public String getTexasQ4A1() {
        return texasQ4A1;
    }

    @JsonProperty("texas_Q4A1")
    public void setTexasQ4A1(String texasQ4A1) {
        this.texasQ4A1 = texasQ4A1;
    }

    @JsonProperty("utah_Q4A1")
    public String getUtahQ4A1() {
        return utahQ4A1;
    }

    @JsonProperty("utah_Q4A1")
    public void setUtahQ4A1(String utahQ4A1) {
        this.utahQ4A1 = utahQ4A1;
    }

    @JsonProperty("washington_Q4A1")
    public String getWashingtonQ4A1() {
        return washingtonQ4A1;
    }

    @JsonProperty("washington_Q4A1")
    public void setWashingtonQ4A1(String washingtonQ4A1) {
        this.washingtonQ4A1 = washingtonQ4A1;
    }

    @JsonProperty("wyoming_Q4A1")
    public String getWyomingQ4A1() {
        return wyomingQ4A1;
    }

    @JsonProperty("wyoming_Q4A1")
    public void setWyomingQ4A1(String wyomingQ4A1) {
        this.wyomingQ4A1 = wyomingQ4A1;
    }

    @JsonProperty("arizona_Q2A1")
    public String getArizonaQ2A1() {
        return arizonaQ2A1;
    }

    @JsonProperty("arizona_Q2A1")
    public void setArizonaQ2A1(String arizonaQ2A1) {
        this.arizonaQ2A1 = arizonaQ2A1;
    }

    @JsonProperty("california_Q2A1")
    public String getCaliforniaQ2A1() {
        return californiaQ2A1;
    }

    @JsonProperty("california_Q2A1")
    public void setCaliforniaQ2A1(String californiaQ2A1) {
        this.californiaQ2A1 = californiaQ2A1;
    }

    @JsonProperty("colorado_Q2A1")
    public String getColoradoQ2A1() {
        return coloradoQ2A1;
    }

    @JsonProperty("colorado_Q2A1")
    public void setColoradoQ2A1(String coloradoQ2A1) {
        this.coloradoQ2A1 = coloradoQ2A1;
    }

    @JsonProperty("idaho_Q2A1")
    public String getIdahoQ2A1() {
        return idahoQ2A1;
    }

    @JsonProperty("idaho_Q2A1")
    public void setIdahoQ2A1(String idahoQ2A1) {
        this.idahoQ2A1 = idahoQ2A1;
    }

    @JsonProperty("montana_Q2A1")
    public String getMontanaQ2A1() {
        return montanaQ2A1;
    }

    @JsonProperty("montana_Q2A1")
    public void setMontanaQ2A1(String montanaQ2A1) {
        this.montanaQ2A1 = montanaQ2A1;
    }

    @JsonProperty("nevada_Q2A1")
    public String getNevadaQ2A1() {
        return nevadaQ2A1;
    }

    @JsonProperty("nevada_Q2A1")
    public void setNevadaQ2A1(String nevadaQ2A1) {
        this.nevadaQ2A1 = nevadaQ2A1;
    }

    @JsonProperty("new mexico_Q2A1")
    public String getNewMexicoQ2A1() {
        return newMexicoQ2A1;
    }

    @JsonProperty("new mexico_Q2A1")
    public void setNewMexicoQ2A1(String newMexicoQ2A1) {
        this.newMexicoQ2A1 = newMexicoQ2A1;
    }

    @JsonProperty("oregon_Q2A1")
    public String getOregonQ2A1() {
        return oregonQ2A1;
    }

    @JsonProperty("oregon_Q2A1")
    public void setOregonQ2A1(String oregonQ2A1) {
        this.oregonQ2A1 = oregonQ2A1;
    }

    @JsonProperty("texas_Q2A1")
    public String getTexasQ2A1() {
        return texasQ2A1;
    }

    @JsonProperty("texas_Q2A1")
    public void setTexasQ2A1(String texasQ2A1) {
        this.texasQ2A1 = texasQ2A1;
    }

    @JsonProperty("utah_Q2A1")
    public String getUtahQ2A1() {
        return utahQ2A1;
    }

    @JsonProperty("utah_Q2A1")
    public void setUtahQ2A1(String utahQ2A1) {
        this.utahQ2A1 = utahQ2A1;
    }

    @JsonProperty("washington_Q2A1")
    public String getWashingtonQ2A1() {
        return washingtonQ2A1;
    }

    @JsonProperty("washington_Q2A1")
    public void setWashingtonQ2A1(String washingtonQ2A1) {
        this.washingtonQ2A1 = washingtonQ2A1;
    }

    @JsonProperty("wyoming_Q2A1")
    public String getWyomingQ2A1() {
        return wyomingQ2A1;
    }

    @JsonProperty("wyoming_Q2A1")
    public void setWyomingQ2A1(String wyomingQ2A1) {
        this.wyomingQ2A1 = wyomingQ2A1;
    }

    @JsonProperty("arizona_Q5A1")
    public String getArizonaQ5A1() {
        return arizonaQ5A1;
    }

    @JsonProperty("arizona_Q5A1")
    public void setArizonaQ5A1(String arizonaQ5A1) {
        this.arizonaQ5A1 = arizonaQ5A1;
    }

    @JsonProperty("california_Q5A1")
    public String getCaliforniaQ5A1() {
        return californiaQ5A1;
    }

    @JsonProperty("california_Q5A1")
    public void setCaliforniaQ5A1(String californiaQ5A1) {
        this.californiaQ5A1 = californiaQ5A1;
    }

    @JsonProperty("colorado_Q5A1")
    public String getColoradoQ5A1() {
        return coloradoQ5A1;
    }

    @JsonProperty("colorado_Q5A1")
    public void setColoradoQ5A1(String coloradoQ5A1) {
        this.coloradoQ5A1 = coloradoQ5A1;
    }

    @JsonProperty("idaho_Q5A1")
    public String getIdahoQ5A1() {
        return idahoQ5A1;
    }

    @JsonProperty("idaho_Q5A1")
    public void setIdahoQ5A1(String idahoQ5A1) {
        this.idahoQ5A1 = idahoQ5A1;
    }

    @JsonProperty("montana_Q5A1")
    public String getMontanaQ5A1() {
        return montanaQ5A1;
    }

    @JsonProperty("montana_Q5A1")
    public void setMontanaQ5A1(String montanaQ5A1) {
        this.montanaQ5A1 = montanaQ5A1;
    }

    @JsonProperty("nevada_Q5A1")
    public String getNevadaQ5A1() {
        return nevadaQ5A1;
    }

    @JsonProperty("nevada_Q5A1")
    public void setNevadaQ5A1(String nevadaQ5A1) {
        this.nevadaQ5A1 = nevadaQ5A1;
    }

    @JsonProperty("new mexico_Q5A1")
    public String getNewMexicoQ5A1() {
        return newMexicoQ5A1;
    }

    @JsonProperty("new mexico_Q5A1")
    public void setNewMexicoQ5A1(String newMexicoQ5A1) {
        this.newMexicoQ5A1 = newMexicoQ5A1;
    }

    @JsonProperty("oregon_Q5A1")
    public String getOregonQ5A1() {
        return oregonQ5A1;
    }

    @JsonProperty("oregon_Q5A1")
    public void setOregonQ5A1(String oregonQ5A1) {
        this.oregonQ5A1 = oregonQ5A1;
    }

    @JsonProperty("texas_Q5A1")
    public String getTexasQ5A1() {
        return texasQ5A1;
    }

    @JsonProperty("texas_Q5A1")
    public void setTexasQ5A1(String texasQ5A1) {
        this.texasQ5A1 = texasQ5A1;
    }

    @JsonProperty("utah_Q5A1")
    public String getUtahQ5A1() {
        return utahQ5A1;
    }

    @JsonProperty("utah_Q5A1")
    public void setUtahQ5A1(String utahQ5A1) {
        this.utahQ5A1 = utahQ5A1;
    }

    @JsonProperty("washington_Q5A1")
    public String getWashingtonQ5A1() {
        return washingtonQ5A1;
    }

    @JsonProperty("washington_Q5A1")
    public void setWashingtonQ5A1(String washingtonQ5A1) {
        this.washingtonQ5A1 = washingtonQ5A1;
    }

    @JsonProperty("wyoming_Q5A1")
    public String getWyomingQ5A1() {
        return wyomingQ5A1;
    }

    @JsonProperty("wyoming_Q5A1")
    public void setWyomingQ5A1(String wyomingQ5A1) {
        this.wyomingQ5A1 = wyomingQ5A1;
    }

    @JsonProperty("arizona_Q3A1")
    public String getArizonaQ3A1() {
        return arizonaQ3A1;
    }

    @JsonProperty("arizona_Q3A1")
    public void setArizonaQ3A1(String arizonaQ3A1) {
        this.arizonaQ3A1 = arizonaQ3A1;
    }

    @JsonProperty("california_Q3A1")
    public String getCaliforniaQ3A1() {
        return californiaQ3A1;
    }

    @JsonProperty("california_Q3A1")
    public void setCaliforniaQ3A1(String californiaQ3A1) {
        this.californiaQ3A1 = californiaQ3A1;
    }

    @JsonProperty("colorado_Q3A1")
    public String getColoradoQ3A1() {
        return coloradoQ3A1;
    }

    @JsonProperty("colorado_Q3A1")
    public void setColoradoQ3A1(String coloradoQ3A1) {
        this.coloradoQ3A1 = coloradoQ3A1;
    }

    @JsonProperty("idaho_Q3A1")
    public String getIdahoQ3A1() {
        return idahoQ3A1;
    }

    @JsonProperty("idaho_Q3A1")
    public void setIdahoQ3A1(String idahoQ3A1) {
        this.idahoQ3A1 = idahoQ3A1;
    }

    @JsonProperty("montana_Q3A1")
    public String getMontanaQ3A1() {
        return montanaQ3A1;
    }

    @JsonProperty("montana_Q3A1")
    public void setMontanaQ3A1(String montanaQ3A1) {
        this.montanaQ3A1 = montanaQ3A1;
    }

    @JsonProperty("nevada_Q3A1")
    public String getNevadaQ3A1() {
        return nevadaQ3A1;
    }

    @JsonProperty("nevada_Q3A1")
    public void setNevadaQ3A1(String nevadaQ3A1) {
        this.nevadaQ3A1 = nevadaQ3A1;
    }

    @JsonProperty("new mexico_Q3A1")
    public String getNewMexicoQ3A1() {
        return newMexicoQ3A1;
    }

    @JsonProperty("new mexico_Q3A1")
    public void setNewMexicoQ3A1(String newMexicoQ3A1) {
        this.newMexicoQ3A1 = newMexicoQ3A1;
    }

    @JsonProperty("oregon_Q3A1")
    public String getOregonQ3A1() {
        return oregonQ3A1;
    }

    @JsonProperty("oregon_Q3A1")
    public void setOregonQ3A1(String oregonQ3A1) {
        this.oregonQ3A1 = oregonQ3A1;
    }

    @JsonProperty("texas_Q3A1")
    public String getTexasQ3A1() {
        return texasQ3A1;
    }

    @JsonProperty("texas_Q3A1")
    public void setTexasQ3A1(String texasQ3A1) {
        this.texasQ3A1 = texasQ3A1;
    }

    @JsonProperty("utah_Q3A1")
    public String getUtahQ3A1() {
        return utahQ3A1;
    }

    @JsonProperty("utah_Q3A1")
    public void setUtahQ3A1(String utahQ3A1) {
        this.utahQ3A1 = utahQ3A1;
    }

    @JsonProperty("washington_Q3A1")
    public String getWashingtonQ3A1() {
        return washingtonQ3A1;
    }

    @JsonProperty("washington_Q3A1")
    public void setWashingtonQ3A1(String washingtonQ3A1) {
        this.washingtonQ3A1 = washingtonQ3A1;
    }

    @JsonProperty("wyoming_Q3A1")
    public String getWyomingQ3A1() {
        return wyomingQ3A1;
    }

    @JsonProperty("wyoming_Q3A1")
    public void setWyomingQ3A1(String wyomingQ3A1) {
        this.wyomingQ3A1 = wyomingQ3A1;
    }

    @JsonProperty("arizona_Q1A2")
    public String getArizonaQ1A2() {
        return arizonaQ1A2;
    }

    @JsonProperty("arizona_Q1A2")
    public void setArizonaQ1A2(String arizonaQ1A2) {
        this.arizonaQ1A2 = arizonaQ1A2;
    }

    @JsonProperty("california_Q1A2")
    public String getCaliforniaQ1A2() {
        return californiaQ1A2;
    }

    @JsonProperty("california_Q1A2")
    public void setCaliforniaQ1A2(String californiaQ1A2) {
        this.californiaQ1A2 = californiaQ1A2;
    }

    @JsonProperty("colorado_Q1A2")
    public String getColoradoQ1A2() {
        return coloradoQ1A2;
    }

    @JsonProperty("colorado_Q1A2")
    public void setColoradoQ1A2(String coloradoQ1A2) {
        this.coloradoQ1A2 = coloradoQ1A2;
    }

    @JsonProperty("idaho_Q1A2")
    public String getIdahoQ1A2() {
        return idahoQ1A2;
    }

    @JsonProperty("idaho_Q1A2")
    public void setIdahoQ1A2(String idahoQ1A2) {
        this.idahoQ1A2 = idahoQ1A2;
    }

    @JsonProperty("montana_Q1A2")
    public String getMontanaQ1A2() {
        return montanaQ1A2;
    }

    @JsonProperty("montana_Q1A2")
    public void setMontanaQ1A2(String montanaQ1A2) {
        this.montanaQ1A2 = montanaQ1A2;
    }

    @JsonProperty("nevada_Q1A2")
    public String getNevadaQ1A2() {
        return nevadaQ1A2;
    }

    @JsonProperty("nevada_Q1A2")
    public void setNevadaQ1A2(String nevadaQ1A2) {
        this.nevadaQ1A2 = nevadaQ1A2;
    }

    @JsonProperty("new mexico_Q1A2")
    public String getNewMexicoQ1A2() {
        return newMexicoQ1A2;
    }

    @JsonProperty("new mexico_Q1A2")
    public void setNewMexicoQ1A2(String newMexicoQ1A2) {
        this.newMexicoQ1A2 = newMexicoQ1A2;
    }

    @JsonProperty("oregon_Q1A2")
    public String getOregonQ1A2() {
        return oregonQ1A2;
    }

    @JsonProperty("oregon_Q1A2")
    public void setOregonQ1A2(String oregonQ1A2) {
        this.oregonQ1A2 = oregonQ1A2;
    }

    @JsonProperty("texas_Q1A2")
    public String getTexasQ1A2() {
        return texasQ1A2;
    }

    @JsonProperty("texas_Q1A2")
    public void setTexasQ1A2(String texasQ1A2) {
        this.texasQ1A2 = texasQ1A2;
    }

    @JsonProperty("utah_Q1A2")
    public String getUtahQ1A2() {
        return utahQ1A2;
    }

    @JsonProperty("utah_Q1A2")
    public void setUtahQ1A2(String utahQ1A2) {
        this.utahQ1A2 = utahQ1A2;
    }

    @JsonProperty("washington_Q1A2")
    public String getWashingtonQ1A2() {
        return washingtonQ1A2;
    }

    @JsonProperty("washington_Q1A2")
    public void setWashingtonQ1A2(String washingtonQ1A2) {
        this.washingtonQ1A2 = washingtonQ1A2;
    }

    @JsonProperty("wyoming_Q1A2")
    public String getWyomingQ1A2() {
        return wyomingQ1A2;
    }

    @JsonProperty("wyoming_Q1A2")
    public void setWyomingQ1A2(String wyomingQ1A2) {
        this.wyomingQ1A2 = wyomingQ1A2;
    }

    @JsonProperty("arizona_Q2A2_ggr")
    public String getArizonaQ2A2Ggr() {
        return arizonaQ2A2Ggr;
    }

    @JsonProperty("arizona_Q2A2_ggr")
    public void setArizonaQ2A2Ggr(String arizonaQ2A2Ggr) {
        this.arizonaQ2A2Ggr = arizonaQ2A2Ggr;
    }

    @JsonProperty("california_Q2A2_ggr")
    public String getCaliforniaQ2A2Ggr() {
        return californiaQ2A2Ggr;
    }

    @JsonProperty("california_Q2A2_ggr")
    public void setCaliforniaQ2A2Ggr(String californiaQ2A2Ggr) {
        this.californiaQ2A2Ggr = californiaQ2A2Ggr;
    }

    @JsonProperty("colorado_Q2A2_ggr")
    public String getColoradoQ2A2Ggr() {
        return coloradoQ2A2Ggr;
    }

    @JsonProperty("colorado_Q2A2_ggr")
    public void setColoradoQ2A2Ggr(String coloradoQ2A2Ggr) {
        this.coloradoQ2A2Ggr = coloradoQ2A2Ggr;
    }

    @JsonProperty("idaho_Q2A2_ggr")
    public String getIdahoQ2A2Ggr() {
        return idahoQ2A2Ggr;
    }

    @JsonProperty("idaho_Q2A2_ggr")
    public void setIdahoQ2A2Ggr(String idahoQ2A2Ggr) {
        this.idahoQ2A2Ggr = idahoQ2A2Ggr;
    }

    @JsonProperty("montana_Q2A2_ggr")
    public String getMontanaQ2A2Ggr() {
        return montanaQ2A2Ggr;
    }

    @JsonProperty("montana_Q2A2_ggr")
    public void setMontanaQ2A2Ggr(String montanaQ2A2Ggr) {
        this.montanaQ2A2Ggr = montanaQ2A2Ggr;
    }

    @JsonProperty("nevada_Q2A2_ggr")
    public String getNevadaQ2A2Ggr() {
        return nevadaQ2A2Ggr;
    }

    @JsonProperty("nevada_Q2A2_ggr")
    public void setNevadaQ2A2Ggr(String nevadaQ2A2Ggr) {
        this.nevadaQ2A2Ggr = nevadaQ2A2Ggr;
    }

    @JsonProperty("new mexico_Q2A2_ggr")
    public String getNewMexicoQ2A2Ggr() {
        return newMexicoQ2A2Ggr;
    }

    @JsonProperty("new mexico_Q2A2_ggr")
    public void setNewMexicoQ2A2Ggr(String newMexicoQ2A2Ggr) {
        this.newMexicoQ2A2Ggr = newMexicoQ2A2Ggr;
    }

    @JsonProperty("oregon_Q2A2_ggr")
    public String getOregonQ2A2Ggr() {
        return oregonQ2A2Ggr;
    }

    @JsonProperty("oregon_Q2A2_ggr")
    public void setOregonQ2A2Ggr(String oregonQ2A2Ggr) {
        this.oregonQ2A2Ggr = oregonQ2A2Ggr;
    }

    @JsonProperty("texas_Q2A2_ggr")
    public String getTexasQ2A2Ggr() {
        return texasQ2A2Ggr;
    }

    @JsonProperty("texas_Q2A2_ggr")
    public void setTexasQ2A2Ggr(String texasQ2A2Ggr) {
        this.texasQ2A2Ggr = texasQ2A2Ggr;
    }

    @JsonProperty("utah_Q2A2_ggr")
    public String getUtahQ2A2Ggr() {
        return utahQ2A2Ggr;
    }

    @JsonProperty("utah_Q2A2_ggr")
    public void setUtahQ2A2Ggr(String utahQ2A2Ggr) {
        this.utahQ2A2Ggr = utahQ2A2Ggr;
    }

    @JsonProperty("washington_Q2A2_ggr")
    public String getWashingtonQ2A2Ggr() {
        return washingtonQ2A2Ggr;
    }

    @JsonProperty("washington_Q2A2_ggr")
    public void setWashingtonQ2A2Ggr(String washingtonQ2A2Ggr) {
        this.washingtonQ2A2Ggr = washingtonQ2A2Ggr;
    }

    @JsonProperty("wyoming_Q2A2_ggr")
    public String getWyomingQ2A2Ggr() {
        return wyomingQ2A2Ggr;
    }

    @JsonProperty("wyoming_Q2A2_ggr")
    public void setWyomingQ2A2Ggr(String wyomingQ2A2Ggr) {
        this.wyomingQ2A2Ggr = wyomingQ2A2Ggr;
    }

    @JsonProperty("arizona_Q4A2")
    public String getArizonaQ4A2() {
        return arizonaQ4A2;
    }

    @JsonProperty("arizona_Q4A2")
    public void setArizonaQ4A2(String arizonaQ4A2) {
        this.arizonaQ4A2 = arizonaQ4A2;
    }

    @JsonProperty("california_Q4A2")
    public String getCaliforniaQ4A2() {
        return californiaQ4A2;
    }

    @JsonProperty("california_Q4A2")
    public void setCaliforniaQ4A2(String californiaQ4A2) {
        this.californiaQ4A2 = californiaQ4A2;
    }

    @JsonProperty("colorado_Q4A2")
    public String getColoradoQ4A2() {
        return coloradoQ4A2;
    }

    @JsonProperty("colorado_Q4A2")
    public void setColoradoQ4A2(String coloradoQ4A2) {
        this.coloradoQ4A2 = coloradoQ4A2;
    }

    @JsonProperty("idaho_Q4A2")
    public String getIdahoQ4A2() {
        return idahoQ4A2;
    }

    @JsonProperty("idaho_Q4A2")
    public void setIdahoQ4A2(String idahoQ4A2) {
        this.idahoQ4A2 = idahoQ4A2;
    }

    @JsonProperty("montana_Q4A2")
    public String getMontanaQ4A2() {
        return montanaQ4A2;
    }

    @JsonProperty("montana_Q4A2")
    public void setMontanaQ4A2(String montanaQ4A2) {
        this.montanaQ4A2 = montanaQ4A2;
    }

    @JsonProperty("nevada_Q4A2")
    public String getNevadaQ4A2() {
        return nevadaQ4A2;
    }

    @JsonProperty("nevada_Q4A2")
    public void setNevadaQ4A2(String nevadaQ4A2) {
        this.nevadaQ4A2 = nevadaQ4A2;
    }

    @JsonProperty("new mexico_Q4A2")
    public String getNewMexicoQ4A2() {
        return newMexicoQ4A2;
    }

    @JsonProperty("new mexico_Q4A2")
    public void setNewMexicoQ4A2(String newMexicoQ4A2) {
        this.newMexicoQ4A2 = newMexicoQ4A2;
    }

    @JsonProperty("oregon_Q4A2")
    public String getOregonQ4A2() {
        return oregonQ4A2;
    }

    @JsonProperty("oregon_Q4A2")
    public void setOregonQ4A2(String oregonQ4A2) {
        this.oregonQ4A2 = oregonQ4A2;
    }

    @JsonProperty("texas_Q4A2")
    public String getTexasQ4A2() {
        return texasQ4A2;
    }

    @JsonProperty("texas_Q4A2")
    public void setTexasQ4A2(String texasQ4A2) {
        this.texasQ4A2 = texasQ4A2;
    }

    @JsonProperty("utah_Q4A2")
    public String getUtahQ4A2() {
        return utahQ4A2;
    }

    @JsonProperty("utah_Q4A2")
    public void setUtahQ4A2(String utahQ4A2) {
        this.utahQ4A2 = utahQ4A2;
    }

    @JsonProperty("washington_Q4A2")
    public String getWashingtonQ4A2() {
        return washingtonQ4A2;
    }

    @JsonProperty("washington_Q4A2")
    public void setWashingtonQ4A2(String washingtonQ4A2) {
        this.washingtonQ4A2 = washingtonQ4A2;
    }

    @JsonProperty("wyoming_Q4A2")
    public String getWyomingQ4A2() {
        return wyomingQ4A2;
    }

    @JsonProperty("wyoming_Q4A2")
    public void setWyomingQ4A2(String wyomingQ4A2) {
        this.wyomingQ4A2 = wyomingQ4A2;
    }

    @JsonProperty("arizona_Q2A2")
    public String getArizonaQ2A2() {
        return arizonaQ2A2;
    }

    @JsonProperty("arizona_Q2A2")
    public void setArizonaQ2A2(String arizonaQ2A2) {
        this.arizonaQ2A2 = arizonaQ2A2;
    }

    @JsonProperty("california_Q2A2")
    public String getCaliforniaQ2A2() {
        return californiaQ2A2;
    }

    @JsonProperty("california_Q2A2")
    public void setCaliforniaQ2A2(String californiaQ2A2) {
        this.californiaQ2A2 = californiaQ2A2;
    }

    @JsonProperty("colorado_Q2A2")
    public String getColoradoQ2A2() {
        return coloradoQ2A2;
    }

    @JsonProperty("colorado_Q2A2")
    public void setColoradoQ2A2(String coloradoQ2A2) {
        this.coloradoQ2A2 = coloradoQ2A2;
    }

    @JsonProperty("idaho_Q2A2")
    public String getIdahoQ2A2() {
        return idahoQ2A2;
    }

    @JsonProperty("idaho_Q2A2")
    public void setIdahoQ2A2(String idahoQ2A2) {
        this.idahoQ2A2 = idahoQ2A2;
    }

    @JsonProperty("montana_Q2A2")
    public String getMontanaQ2A2() {
        return montanaQ2A2;
    }

    @JsonProperty("montana_Q2A2")
    public void setMontanaQ2A2(String montanaQ2A2) {
        this.montanaQ2A2 = montanaQ2A2;
    }

    @JsonProperty("nevada_Q2A2")
    public String getNevadaQ2A2() {
        return nevadaQ2A2;
    }

    @JsonProperty("nevada_Q2A2")
    public void setNevadaQ2A2(String nevadaQ2A2) {
        this.nevadaQ2A2 = nevadaQ2A2;
    }

    @JsonProperty("new mexico_Q2A2")
    public String getNewMexicoQ2A2() {
        return newMexicoQ2A2;
    }

    @JsonProperty("new mexico_Q2A2")
    public void setNewMexicoQ2A2(String newMexicoQ2A2) {
        this.newMexicoQ2A2 = newMexicoQ2A2;
    }

    @JsonProperty("oregon_Q2A2")
    public String getOregonQ2A2() {
        return oregonQ2A2;
    }

    @JsonProperty("oregon_Q2A2")
    public void setOregonQ2A2(String oregonQ2A2) {
        this.oregonQ2A2 = oregonQ2A2;
    }

    @JsonProperty("texas_Q2A2")
    public String getTexasQ2A2() {
        return texasQ2A2;
    }

    @JsonProperty("texas_Q2A2")
    public void setTexasQ2A2(String texasQ2A2) {
        this.texasQ2A2 = texasQ2A2;
    }

    @JsonProperty("utah_Q2A2")
    public String getUtahQ2A2() {
        return utahQ2A2;
    }

    @JsonProperty("utah_Q2A2")
    public void setUtahQ2A2(String utahQ2A2) {
        this.utahQ2A2 = utahQ2A2;
    }

    @JsonProperty("washington_Q2A2")
    public String getWashingtonQ2A2() {
        return washingtonQ2A2;
    }

    @JsonProperty("washington_Q2A2")
    public void setWashingtonQ2A2(String washingtonQ2A2) {
        this.washingtonQ2A2 = washingtonQ2A2;
    }

    @JsonProperty("wyoming_Q2A2")
    public String getWyomingQ2A2() {
        return wyomingQ2A2;
    }

    @JsonProperty("wyoming_Q2A2")
    public void setWyomingQ2A2(String wyomingQ2A2) {
        this.wyomingQ2A2 = wyomingQ2A2;
    }

    @JsonProperty("arizona_Q5A2")
    public String getArizonaQ5A2() {
        return arizonaQ5A2;
    }

    @JsonProperty("arizona_Q5A2")
    public void setArizonaQ5A2(String arizonaQ5A2) {
        this.arizonaQ5A2 = arizonaQ5A2;
    }

    @JsonProperty("california_Q5A2")
    public String getCaliforniaQ5A2() {
        return californiaQ5A2;
    }

    @JsonProperty("california_Q5A2")
    public void setCaliforniaQ5A2(String californiaQ5A2) {
        this.californiaQ5A2 = californiaQ5A2;
    }

    @JsonProperty("colorado_Q5A2")
    public String getColoradoQ5A2() {
        return coloradoQ5A2;
    }

    @JsonProperty("colorado_Q5A2")
    public void setColoradoQ5A2(String coloradoQ5A2) {
        this.coloradoQ5A2 = coloradoQ5A2;
    }

    @JsonProperty("idaho_Q5A2")
    public String getIdahoQ5A2() {
        return idahoQ5A2;
    }

    @JsonProperty("idaho_Q5A2")
    public void setIdahoQ5A2(String idahoQ5A2) {
        this.idahoQ5A2 = idahoQ5A2;
    }

    @JsonProperty("montana_Q5A2")
    public String getMontanaQ5A2() {
        return montanaQ5A2;
    }

    @JsonProperty("montana_Q5A2")
    public void setMontanaQ5A2(String montanaQ5A2) {
        this.montanaQ5A2 = montanaQ5A2;
    }

    @JsonProperty("nevada_Q5A2")
    public String getNevadaQ5A2() {
        return nevadaQ5A2;
    }

    @JsonProperty("nevada_Q5A2")
    public void setNevadaQ5A2(String nevadaQ5A2) {
        this.nevadaQ5A2 = nevadaQ5A2;
    }

    @JsonProperty("new mexico_Q5A2")
    public String getNewMexicoQ5A2() {
        return newMexicoQ5A2;
    }

    @JsonProperty("new mexico_Q5A2")
    public void setNewMexicoQ5A2(String newMexicoQ5A2) {
        this.newMexicoQ5A2 = newMexicoQ5A2;
    }

    @JsonProperty("oregon_Q5A2")
    public String getOregonQ5A2() {
        return oregonQ5A2;
    }

    @JsonProperty("oregon_Q5A2")
    public void setOregonQ5A2(String oregonQ5A2) {
        this.oregonQ5A2 = oregonQ5A2;
    }

    @JsonProperty("texas_Q5A2")
    public String getTexasQ5A2() {
        return texasQ5A2;
    }

    @JsonProperty("texas_Q5A2")
    public void setTexasQ5A2(String texasQ5A2) {
        this.texasQ5A2 = texasQ5A2;
    }

    @JsonProperty("utah_Q5A2")
    public String getUtahQ5A2() {
        return utahQ5A2;
    }

    @JsonProperty("utah_Q5A2")
    public void setUtahQ5A2(String utahQ5A2) {
        this.utahQ5A2 = utahQ5A2;
    }

    @JsonProperty("washington_Q5A2")
    public String getWashingtonQ5A2() {
        return washingtonQ5A2;
    }

    @JsonProperty("washington_Q5A2")
    public void setWashingtonQ5A2(String washingtonQ5A2) {
        this.washingtonQ5A2 = washingtonQ5A2;
    }

    @JsonProperty("wyoming_Q5A2")
    public String getWyomingQ5A2() {
        return wyomingQ5A2;
    }

    @JsonProperty("wyoming_Q5A2")
    public void setWyomingQ5A2(String wyomingQ5A2) {
        this.wyomingQ5A2 = wyomingQ5A2;
    }

    @JsonProperty("arizona_Q3A2")
    public String getArizonaQ3A2() {
        return arizonaQ3A2;
    }

    @JsonProperty("arizona_Q3A2")
    public void setArizonaQ3A2(String arizonaQ3A2) {
        this.arizonaQ3A2 = arizonaQ3A2;
    }

    @JsonProperty("california_Q3A2")
    public String getCaliforniaQ3A2() {
        return californiaQ3A2;
    }

    @JsonProperty("california_Q3A2")
    public void setCaliforniaQ3A2(String californiaQ3A2) {
        this.californiaQ3A2 = californiaQ3A2;
    }

    @JsonProperty("colorado_Q3A2")
    public String getColoradoQ3A2() {
        return coloradoQ3A2;
    }

    @JsonProperty("colorado_Q3A2")
    public void setColoradoQ3A2(String coloradoQ3A2) {
        this.coloradoQ3A2 = coloradoQ3A2;
    }

    @JsonProperty("idaho_Q3A2")
    public String getIdahoQ3A2() {
        return idahoQ3A2;
    }

    @JsonProperty("idaho_Q3A2")
    public void setIdahoQ3A2(String idahoQ3A2) {
        this.idahoQ3A2 = idahoQ3A2;
    }

    @JsonProperty("montana_Q3A2")
    public String getMontanaQ3A2() {
        return montanaQ3A2;
    }

    @JsonProperty("montana_Q3A2")
    public void setMontanaQ3A2(String montanaQ3A2) {
        this.montanaQ3A2 = montanaQ3A2;
    }

    @JsonProperty("nevada_Q3A2")
    public String getNevadaQ3A2() {
        return nevadaQ3A2;
    }

    @JsonProperty("nevada_Q3A2")
    public void setNevadaQ3A2(String nevadaQ3A2) {
        this.nevadaQ3A2 = nevadaQ3A2;
    }

    @JsonProperty("new mexico_Q3A2")
    public String getNewMexicoQ3A2() {
        return newMexicoQ3A2;
    }

    @JsonProperty("new mexico_Q3A2")
    public void setNewMexicoQ3A2(String newMexicoQ3A2) {
        this.newMexicoQ3A2 = newMexicoQ3A2;
    }

    @JsonProperty("oregon_Q3A2")
    public String getOregonQ3A2() {
        return oregonQ3A2;
    }

    @JsonProperty("oregon_Q3A2")
    public void setOregonQ3A2(String oregonQ3A2) {
        this.oregonQ3A2 = oregonQ3A2;
    }

    @JsonProperty("texas_Q3A2")
    public String getTexasQ3A2() {
        return texasQ3A2;
    }

    @JsonProperty("texas_Q3A2")
    public void setTexasQ3A2(String texasQ3A2) {
        this.texasQ3A2 = texasQ3A2;
    }

    @JsonProperty("utah_Q3A2")
    public String getUtahQ3A2() {
        return utahQ3A2;
    }

    @JsonProperty("utah_Q3A2")
    public void setUtahQ3A2(String utahQ3A2) {
        this.utahQ3A2 = utahQ3A2;
    }

    @JsonProperty("washington_Q3A2")
    public String getWashingtonQ3A2() {
        return washingtonQ3A2;
    }

    @JsonProperty("washington_Q3A2")
    public void setWashingtonQ3A2(String washingtonQ3A2) {
        this.washingtonQ3A2 = washingtonQ3A2;
    }

    @JsonProperty("wyoming_Q3A2")
    public String getWyomingQ3A2() {
        return wyomingQ3A2;
    }

    @JsonProperty("wyoming_Q3A2")
    public void setWyomingQ3A2(String wyomingQ3A2) {
        this.wyomingQ3A2 = wyomingQ3A2;
    }

    @JsonProperty("arizona_Q2A1_mfg")
    public String getArizonaQ2A1Mfg() {
        return arizonaQ2A1Mfg;
    }

    @JsonProperty("arizona_Q2A1_mfg")
    public void setArizonaQ2A1Mfg(String arizonaQ2A1Mfg) {
        this.arizonaQ2A1Mfg = arizonaQ2A1Mfg;
    }

    @JsonProperty("california_Q2A1_mfg")
    public String getCaliforniaQ2A1Mfg() {
        return californiaQ2A1Mfg;
    }

    @JsonProperty("california_Q2A1_mfg")
    public void setCaliforniaQ2A1Mfg(String californiaQ2A1Mfg) {
        this.californiaQ2A1Mfg = californiaQ2A1Mfg;
    }

    @JsonProperty("colorado_Q2A1_mfg")
    public String getColoradoQ2A1Mfg() {
        return coloradoQ2A1Mfg;
    }

    @JsonProperty("colorado_Q2A1_mfg")
    public void setColoradoQ2A1Mfg(String coloradoQ2A1Mfg) {
        this.coloradoQ2A1Mfg = coloradoQ2A1Mfg;
    }

    @JsonProperty("idaho_Q2A1_mfg")
    public String getIdahoQ2A1Mfg() {
        return idahoQ2A1Mfg;
    }

    @JsonProperty("idaho_Q2A1_mfg")
    public void setIdahoQ2A1Mfg(String idahoQ2A1Mfg) {
        this.idahoQ2A1Mfg = idahoQ2A1Mfg;
    }

    @JsonProperty("montana_Q2A1_mfg")
    public String getMontanaQ2A1Mfg() {
        return montanaQ2A1Mfg;
    }

    @JsonProperty("montana_Q2A1_mfg")
    public void setMontanaQ2A1Mfg(String montanaQ2A1Mfg) {
        this.montanaQ2A1Mfg = montanaQ2A1Mfg;
    }

    @JsonProperty("nevada_Q2A1_mfg")
    public String getNevadaQ2A1Mfg() {
        return nevadaQ2A1Mfg;
    }

    @JsonProperty("nevada_Q2A1_mfg")
    public void setNevadaQ2A1Mfg(String nevadaQ2A1Mfg) {
        this.nevadaQ2A1Mfg = nevadaQ2A1Mfg;
    }

    @JsonProperty("new mexico_Q2A1_mfg")
    public String getNewMexicoQ2A1Mfg() {
        return newMexicoQ2A1Mfg;
    }

    @JsonProperty("new mexico_Q2A1_mfg")
    public void setNewMexicoQ2A1Mfg(String newMexicoQ2A1Mfg) {
        this.newMexicoQ2A1Mfg = newMexicoQ2A1Mfg;
    }

    @JsonProperty("oregon_Q2A1_mfg")
    public String getOregonQ2A1Mfg() {
        return oregonQ2A1Mfg;
    }

    @JsonProperty("oregon_Q2A1_mfg")
    public void setOregonQ2A1Mfg(String oregonQ2A1Mfg) {
        this.oregonQ2A1Mfg = oregonQ2A1Mfg;
    }

    @JsonProperty("texas_Q2A1_mfg")
    public String getTexasQ2A1Mfg() {
        return texasQ2A1Mfg;
    }

    @JsonProperty("texas_Q2A1_mfg")
    public void setTexasQ2A1Mfg(String texasQ2A1Mfg) {
        this.texasQ2A1Mfg = texasQ2A1Mfg;
    }

    @JsonProperty("utah_Q2A1_mfg")
    public String getUtahQ2A1Mfg() {
        return utahQ2A1Mfg;
    }

    @JsonProperty("utah_Q2A1_mfg")
    public void setUtahQ2A1Mfg(String utahQ2A1Mfg) {
        this.utahQ2A1Mfg = utahQ2A1Mfg;
    }

    @JsonProperty("washington_Q2A1_mfg")
    public String getWashingtonQ2A1Mfg() {
        return washingtonQ2A1Mfg;
    }

    @JsonProperty("washington_Q2A1_mfg")
    public void setWashingtonQ2A1Mfg(String washingtonQ2A1Mfg) {
        this.washingtonQ2A1Mfg = washingtonQ2A1Mfg;
    }

    @JsonProperty("wyoming_Q2A1_mfg")
    public String getWyomingQ2A1Mfg() {
        return wyomingQ2A1Mfg;
    }

    @JsonProperty("wyoming_Q2A1_mfg")
    public void setWyomingQ2A1Mfg(String wyomingQ2A1Mfg) {
        this.wyomingQ2A1Mfg = wyomingQ2A1Mfg;
    }

    @JsonProperty("arizona_Q2A2_mfg")
    public String getArizonaQ2A2Mfg() {
        return arizonaQ2A2Mfg;
    }

    @JsonProperty("arizona_Q2A2_mfg")
    public void setArizonaQ2A2Mfg(String arizonaQ2A2Mfg) {
        this.arizonaQ2A2Mfg = arizonaQ2A2Mfg;
    }

    @JsonProperty("california_Q2A2_mfg")
    public String getCaliforniaQ2A2Mfg() {
        return californiaQ2A2Mfg;
    }

    @JsonProperty("california_Q2A2_mfg")
    public void setCaliforniaQ2A2Mfg(String californiaQ2A2Mfg) {
        this.californiaQ2A2Mfg = californiaQ2A2Mfg;
    }

    @JsonProperty("colorado_Q2A2_mfg")
    public String getColoradoQ2A2Mfg() {
        return coloradoQ2A2Mfg;
    }

    @JsonProperty("colorado_Q2A2_mfg")
    public void setColoradoQ2A2Mfg(String coloradoQ2A2Mfg) {
        this.coloradoQ2A2Mfg = coloradoQ2A2Mfg;
    }

    @JsonProperty("idaho_Q2A2_mfg")
    public String getIdahoQ2A2Mfg() {
        return idahoQ2A2Mfg;
    }

    @JsonProperty("idaho_Q2A2_mfg")
    public void setIdahoQ2A2Mfg(String idahoQ2A2Mfg) {
        this.idahoQ2A2Mfg = idahoQ2A2Mfg;
    }

    @JsonProperty("montana_Q2A2_mfg")
    public String getMontanaQ2A2Mfg() {
        return montanaQ2A2Mfg;
    }

    @JsonProperty("montana_Q2A2_mfg")
    public void setMontanaQ2A2Mfg(String montanaQ2A2Mfg) {
        this.montanaQ2A2Mfg = montanaQ2A2Mfg;
    }

    @JsonProperty("nevada_Q2A2_mfg")
    public String getNevadaQ2A2Mfg() {
        return nevadaQ2A2Mfg;
    }

    @JsonProperty("nevada_Q2A2_mfg")
    public void setNevadaQ2A2Mfg(String nevadaQ2A2Mfg) {
        this.nevadaQ2A2Mfg = nevadaQ2A2Mfg;
    }

    @JsonProperty("new mexico_Q2A2_mfg")
    public String getNewMexicoQ2A2Mfg() {
        return newMexicoQ2A2Mfg;
    }

    @JsonProperty("new mexico_Q2A2_mfg")
    public void setNewMexicoQ2A2Mfg(String newMexicoQ2A2Mfg) {
        this.newMexicoQ2A2Mfg = newMexicoQ2A2Mfg;
    }

    @JsonProperty("oregon_Q2A2_mfg")
    public String getOregonQ2A2Mfg() {
        return oregonQ2A2Mfg;
    }

    @JsonProperty("oregon_Q2A2_mfg")
    public void setOregonQ2A2Mfg(String oregonQ2A2Mfg) {
        this.oregonQ2A2Mfg = oregonQ2A2Mfg;
    }

    @JsonProperty("texas_Q2A2_mfg")
    public String getTexasQ2A2Mfg() {
        return texasQ2A2Mfg;
    }

    @JsonProperty("texas_Q2A2_mfg")
    public void setTexasQ2A2Mfg(String texasQ2A2Mfg) {
        this.texasQ2A2Mfg = texasQ2A2Mfg;
    }

    @JsonProperty("utah_Q2A2_mfg")
    public String getUtahQ2A2Mfg() {
        return utahQ2A2Mfg;
    }

    @JsonProperty("utah_Q2A2_mfg")
    public void setUtahQ2A2Mfg(String utahQ2A2Mfg) {
        this.utahQ2A2Mfg = utahQ2A2Mfg;
    }

    @JsonProperty("washington_Q2A2_mfg")
    public String getWashingtonQ2A2Mfg() {
        return washingtonQ2A2Mfg;
    }

    @JsonProperty("washington_Q2A2_mfg")
    public void setWashingtonQ2A2Mfg(String washingtonQ2A2Mfg) {
        this.washingtonQ2A2Mfg = washingtonQ2A2Mfg;
    }

    @JsonProperty("wyoming_Q2A2_mfg")
    public String getWyomingQ2A2Mfg() {
        return wyomingQ2A2Mfg;
    }

    @JsonProperty("wyoming_Q2A2_mfg")
    public void setWyomingQ2A2Mfg(String wyomingQ2A2Mfg) {
        this.wyomingQ2A2Mfg = wyomingQ2A2Mfg;
    }

    @JsonProperty("datearizona")
    public String getDatearizona() {
        return datearizona;
    }

    @JsonProperty("datearizona")
    public void setDatearizona(String datearizona) {
        this.datearizona = datearizona;
    }

    @JsonProperty("datecalifornia")
    public String getDatecalifornia() {
        return datecalifornia;
    }

    @JsonProperty("datecalifornia")
    public void setDatecalifornia(String datecalifornia) {
        this.datecalifornia = datecalifornia;
    }

    @JsonProperty("datecolorado")
    public String getDatecolorado() {
        return datecolorado;
    }

    @JsonProperty("datecolorado")
    public void setDatecolorado(String datecolorado) {
        this.datecolorado = datecolorado;
    }

    @JsonProperty("dateidaho")
    public String getDateidaho() {
        return dateidaho;
    }

    @JsonProperty("dateidaho")
    public void setDateidaho(String dateidaho) {
        this.dateidaho = dateidaho;
    }

    @JsonProperty("datemontana")
    public String getDatemontana() {
        return datemontana;
    }

    @JsonProperty("datemontana")
    public void setDatemontana(String datemontana) {
        this.datemontana = datemontana;
    }

    @JsonProperty("datenevada")
    public String getDatenevada() {
        return datenevada;
    }

    @JsonProperty("datenevada")
    public void setDatenevada(String datenevada) {
        this.datenevada = datenevada;
    }

    @JsonProperty("datenew mexico")
    public String getDatenewMexico() {
        return datenewMexico;
    }

    @JsonProperty("datenew mexico")
    public void setDatenewMexico(String datenewMexico) {
        this.datenewMexico = datenewMexico;
    }

    @JsonProperty("dateoregon")
    public String getDateoregon() {
        return dateoregon;
    }

    @JsonProperty("dateoregon")
    public void setDateoregon(String dateoregon) {
        this.dateoregon = dateoregon;
    }

    @JsonProperty("datetexas")
    public String getDatetexas() {
        return datetexas;
    }

    @JsonProperty("datetexas")
    public void setDatetexas(String datetexas) {
        this.datetexas = datetexas;
    }

    @JsonProperty("dateutah")
    public String getDateutah() {
        return dateutah;
    }

    @JsonProperty("dateutah")
    public void setDateutah(String dateutah) {
        this.dateutah = dateutah;
    }

    @JsonProperty("datewashington")
    public String getDatewashington() {
        return datewashington;
    }

    @JsonProperty("datewashington")
    public void setDatewashington(String datewashington) {
        this.datewashington = datewashington;
    }

    @JsonProperty("datewyoming")
    public String getDatewyoming() {
        return datewyoming;
    }

    @JsonProperty("datewyoming")
    public void setDatewyoming(String datewyoming) {
        this.datewyoming = datewyoming;
    }

    @JsonProperty("arizona")
    public String getArizona() {
        return arizona;
    }

    @JsonProperty("arizona")
    public void setArizona(String arizona) {
        this.arizona = arizona;
    }

    @JsonProperty("california")
    public String getCalifornia() {
        return california;
    }

    @JsonProperty("california")
    public void setCalifornia(String california) {
        this.california = california;
    }

    @JsonProperty("colorado")
    public String getColorado() {
        return colorado;
    }

    @JsonProperty("colorado")
    public void setColorado(String colorado) {
        this.colorado = colorado;
    }

    @JsonProperty("idaho")
    public String getIdaho() {
        return idaho;
    }

    @JsonProperty("idaho")
    public void setIdaho(String idaho) {
        this.idaho = idaho;
    }

    @JsonProperty("montana")
    public String getMontana() {
        return montana;
    }

    @JsonProperty("montana")
    public void setMontana(String montana) {
        this.montana = montana;
    }

    @JsonProperty("nevada")
    public String getNevada() {
        return nevada;
    }

    @JsonProperty("nevada")
    public void setNevada(String nevada) {
        this.nevada = nevada;
    }

    @JsonProperty("new_mexico")
    public String getNewMexico() {
        return newMexico;
    }

    @JsonProperty("new_mexico")
    public void setNewMexico(String newMexico) {
        this.newMexico = newMexico;
    }

    @JsonProperty("oregon")
    public String getOregon() {
        return oregon;
    }

    @JsonProperty("oregon")
    public void setOregon(String oregon) {
        this.oregon = oregon;
    }

    @JsonProperty("texas")
    public String getTexas() {
        return texas;
    }

    @JsonProperty("texas")
    public void setTexas(String texas) {
        this.texas = texas;
    }

    @JsonProperty("utah")
    public String getUtah() {
        return utah;
    }

    @JsonProperty("utah")
    public void setUtah(String utah) {
        this.utah = utah;
    }

    @JsonProperty("washington")
    public String getWashington() {
        return washington;
    }

    @JsonProperty("washington")
    public void setWashington(String washington) {
        this.washington = washington;
    }

    @JsonProperty("wyoming")
    public String getWyoming() {
        return wyoming;
    }

    @JsonProperty("wyoming")
    public void setWyoming(String wyoming) {
        this.wyoming = wyoming;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
