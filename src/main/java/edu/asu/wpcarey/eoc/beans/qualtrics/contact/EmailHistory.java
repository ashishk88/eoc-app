
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
    "emailDistributionId",
    "date",
    "type",
    "result",
    "read",
    "surveyId"
})
public class EmailHistory {

    @JsonProperty("emailDistributionId")
    private String emailDistributionId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("type")
    private String type;
    @JsonProperty("result")
    private String result;
    @JsonProperty("read")
    private Boolean read;
    @JsonProperty("surveyId")
    private String surveyId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("emailDistributionId")
    public String getEmailDistributionId() {
        return emailDistributionId;
    }

    @JsonProperty("emailDistributionId")
    public void setEmailDistributionId(String emailDistributionId) {
        this.emailDistributionId = emailDistributionId;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty("read")
    public Boolean getRead() {
        return read;
    }

    @JsonProperty("read")
    public void setRead(Boolean read) {
        this.read = read;
    }

    @JsonProperty("surveyId")
    public String getSurveyId() {
        return surveyId;
    }

    @JsonProperty("surveyId")
    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
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
