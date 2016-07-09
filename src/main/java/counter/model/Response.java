package counter.model;

/**
 * Created by yxiangling on 2016/7/9.
 */
public class Response {
    private String generalResponse;
    private String disCountResponse;

    public Response(String generalResponse, String disCountResponse) {

        this.generalResponse = generalResponse;
        this.disCountResponse = disCountResponse;
    }

    public String getGeneralResponse() {
        return generalResponse;
    }

    public String getDisCountResponse() {
        return disCountResponse;
    }
}
