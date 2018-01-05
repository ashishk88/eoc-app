
package edu.asu.wpcarey.eoc.beans.qualtrics.contact;

import java.util.HashMap;
import java.util.List;
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
    "id",
    "firstName",
    "lastName",
    "email",
    "externalDataReference",
    "embeddedData",
    "language",
    "unsubscribed",
    "responseHistory",
    "emailHistory"
})
public class Element {

    @JsonProperty("id")
    private String id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("externalDataReference")
    private Object externalDataReference;
    @JsonProperty("embeddedData")
    private EmbeddedData embeddedData;
    @JsonProperty("language")
    private Object language;
    @JsonProperty("unsubscribed")
    private Boolean unsubscribed;
    @JsonProperty("responseHistory")
    private List<Object> responseHistory = null;
    @JsonProperty("emailHistory")
    private List<EmailHistory> emailHistory = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("externalDataReference")
    public Object getExternalDataReference() {
        return externalDataReference;
    }

    @JsonProperty("externalDataReference")
    public void setExternalDataReference(Object externalDataReference) {
        this.externalDataReference = externalDataReference;
    }

    @JsonProperty("embeddedData")
    public EmbeddedData getEmbeddedData() {
        return embeddedData;
    }

    @JsonProperty("embeddedData")
    public void setEmbeddedData(EmbeddedData embeddedData) {
        this.embeddedData = embeddedData;
    }

    @JsonProperty("language")
    public Object getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(Object language) {
        this.language = language;
    }

    @JsonProperty("unsubscribed")
    public Boolean getUnsubscribed() {
        return unsubscribed;
    }

    @JsonProperty("unsubscribed")
    public void setUnsubscribed(Boolean unsubscribed) {
        this.unsubscribed = unsubscribed;
    }

    @JsonProperty("responseHistory")
    public List<Object> getResponseHistory() {
        return responseHistory;
    }

    @JsonProperty("responseHistory")
    public void setResponseHistory(List<Object> responseHistory) {
        this.responseHistory = responseHistory;
    }

    @JsonProperty("emailHistory")
    public List<EmailHistory> getEmailHistory() {
        return emailHistory;
    }

    @JsonProperty("emailHistory")
    public void setEmailHistory(List<EmailHistory> emailHistory) {
        this.emailHistory = emailHistory;
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
