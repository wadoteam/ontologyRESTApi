package io.swagger.model;

import javax.validation.constraints.*;


import com.sun.istack.internal.NotNull;
import io.swagger.annotations.*;
import java.util.Objects;


public class Repository   {
  
  private Integer id = null;
  private String url = null;
  private String description = null;

  /**
   **/
  public Repository id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "3", required = true, value = "")
  @NotNull
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  public Repository url(String url) {
    this.url = url;
    return this;
  }

  
  @ApiModelProperty(example = "http://github.com/wadoteam/repository", value = "")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   **/
  public Repository description(String description) {
    this.description = description;
    return this;
  }

  
  @ApiModelProperty(example = "Awesome repo description", value = "")
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
    Repository repository = (Repository) o;
    return Objects.equals(id, repository.id) &&
        Objects.equals(url, repository.url) &&
        Objects.equals(description, repository.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Repository {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

