package io.swagger.model;

import io.swagger.model.ProgrammingLanguage;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class DevelopmentEnvironment   {
  
  private String name = null;
  private List<ProgrammingLanguage> languages = new ArrayList<ProgrammingLanguage>();
  private String description = null;

  /**
   **/
  public DevelopmentEnvironment name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "Awesome DevEnv", required = true, value = "")
  @NotNull
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public DevelopmentEnvironment languages(List<ProgrammingLanguage> languages) {
    this.languages = languages;
    return this;
  }

  
  @ApiModelProperty(value = "")
  public List<ProgrammingLanguage> getLanguages() {
    return languages;
  }
  public void setLanguages(List<ProgrammingLanguage> languages) {
    this.languages = languages;
  }

  /**
   **/
  public DevelopmentEnvironment description(String description) {
    this.description = description;
    return this;
  }

  
  @ApiModelProperty(example = "Awesome description", value = "")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DevelopmentEnvironment developmentEnvironment = (DevelopmentEnvironment) o;
    return Objects.equals(name, developmentEnvironment.name) &&
        Objects.equals(languages, developmentEnvironment.languages) &&
        Objects.equals(description, developmentEnvironment.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, languages, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DevelopmentEnvironment {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

