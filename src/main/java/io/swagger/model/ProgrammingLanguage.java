package io.swagger.model;

import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class ProgrammingLanguage   {
  
  private String name = null;
  private String description = null;

  /**
   **/
  public ProgrammingLanguage name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "Java", required = true, value = "")
  @NotNull
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public ProgrammingLanguage description(String description) {
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
    ProgrammingLanguage programmingLanguage = (ProgrammingLanguage) o;
    return Objects.equals(name, programmingLanguage.name) &&
        Objects.equals(description, programmingLanguage.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgrammingLanguage {\n");
    
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

