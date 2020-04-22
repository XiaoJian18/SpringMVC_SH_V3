package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author XJ
 * @date 2020-4-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NeedHomework {
    private long homework_id;
    private String title;
    private String content;
    private Timestamp createTime;
    private Timestamp updateTime;

}
