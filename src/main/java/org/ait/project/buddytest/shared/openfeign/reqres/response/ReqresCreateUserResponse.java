package org.ait.project.buddytest.shared.openfeign.reqres.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReqresCreateUserResponse{

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private String id;

	@JsonProperty("job")
	private String job;
}