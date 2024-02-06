package api.models.args.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDescription {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateTaskRequest {
        private String jsonrpc;
        private String method;
        private long id;
        ParamsCreate params;
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class ParamsCreate {
            private String title;
            @JsonProperty("project_id")
            private int projectId;
            private String description;
            private String color_id;
            private String date_started;
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RemoveTaskRequest {
        private String jsonrpc;
        private String method;
        private long id;
        private ParamsRemote params;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class ParamsRemote {
            private int task_id;
        }
    }
}
