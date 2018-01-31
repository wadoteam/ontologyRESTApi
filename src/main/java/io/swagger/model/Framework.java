package io.swagger.model;

import io.swagger.model.ProgrammingLanguage;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class Framework   {
  
  private ProgrammingLanguage language = null;
  private String name = null;
  private String description = null;

  /**
   **/
  public Framework language(ProgrammingLanguage language) {
    this.language = language;
    return this;
  }

  
  @ApiModelProperty(value = "")
  public ProgrammingLanguage getLanguage() {
    return language;
  }
  public void setLanguage(ProgrammingLanguage language) {
    this.language = language;
  }

  /**
   **/
  public Framework name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "Spring", required = true, value = "")
  @NotNull
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public Framework description(String description) {
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
    Framework framework = (Framework) o;
    return Objects.equals(language, framework.language) &&
        Objects.equals(name, framework.name) &&
        Objects.equals(description, framework.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(language, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Framework {\n");
    
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

