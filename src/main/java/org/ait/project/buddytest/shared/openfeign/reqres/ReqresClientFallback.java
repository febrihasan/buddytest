package org.ait.project.buddytest.shared.openfeign.reqres;

import org.ait.project.buddytest.shared.openfeign.reqres.request.ReqresCreateUserRequest;
import org.ait.project.buddytest.shared.openfeign.reqres.response.ReqresCreateUserResponse;
import org.ait.project.buddytest.shared.openfeign.reqres.response.ReqresListUserResponse;
import org.springframework.stereotype.Component;

@Component
public class ReqresClientFallback implements ReqresClient{

  /**
  * When Openfeign Call failed, then do this
  * */
  @Override
  public ReqresListUserResponse getListUser(String page) {
    return null;
  }

  @Override
  public ReqresCreateUserResponse createUserReqres(
      ReqresCreateUserRequest reqresCreateUserRequest) {
    return null;
  }
}
