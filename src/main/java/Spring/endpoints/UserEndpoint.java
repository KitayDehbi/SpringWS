package Spring.endpoints;

import Spring.repo.UserRepository;

import com.dehbi.springsoap.GetRolesRequest;
import com.dehbi.springsoap.GetRolesResponse;
import com.dehbi.springsoap.GetUserRequest;
import com.dehbi.springsoap.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://www.dehbi.com/springsoap";
    @Autowired
    private UserRepository userRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userRepository.findUser(request.getCode()));
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRolesRequest")
    @ResponsePayload
    public GetRolesResponse getRoles(@RequestPayload GetRolesRequest request) {
        GetRolesResponse response = new GetRolesResponse();
        response.setRoles(userRepository.findRoles(request.getCode()));
        return response;
    }
}
