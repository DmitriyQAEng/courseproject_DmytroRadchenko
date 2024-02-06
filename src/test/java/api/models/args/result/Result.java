package api.models.args.result;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String jsonrpc;
    private Object result;
    private String error;
    private int id;

}



