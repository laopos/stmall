package stmall.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import stmall.OrderApplication;
import stmall.domain.OrderModified;
import stmall.domain.OrderPlaced;

@Entity
@Table(name = "OrdeMgmt_table")
@Data
//<<< DDD / Aggregate Root
public class OrdeMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String productName;

    private Long productId;

    private Integer qty;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderModified orderModified = new OrderModified(this);
        orderModified.publishAfterCommit();
    }

    public static OrdeMgmtRepository repository() {
        OrdeMgmtRepository ordeMgmtRepository = OrderApplication.applicationContext.getBean(
            OrdeMgmtRepository.class
        );
        return ordeMgmtRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        OrdeMgmt ordeMgmt = new OrdeMgmt();
        repository().save(ordeMgmt);

        */

        /** Example 2:  finding and process
        
        // if deliveryStarted.cjLogisId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> deliveryMap = mapper.convertValue(deliveryStarted.getCjLogisId(), Map.class);

        repository().findById(deliveryStarted.get???()).ifPresent(ordeMgmt->{
            
            ordeMgmt // do something
            repository().save(ordeMgmt);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
