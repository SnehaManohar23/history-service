package edu.iu.snemanoh.historyservice.rabbitmq;

import edu.iu.snemanoh.historyservice.repository.PrimesHistoryRepository;
import com.google.gson.Gson;
import edu.iu.snemanoh.historyservice.model.PimesRecord;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MQReceiver {
    private final PrimesHistoryRepository primesHistoryRepository;
    public MQReceiver(PrimesHistoryRepository primesHistoryRepository){
        this.primesHistoryRepository=primesHistoryRepository;
    }

    @RabbitListener(queues = {"primes"})
    public void receiveMessage(@Payload String message){
        System.out.println(message);
        Gson gson=new Gson();
        PimesRecord primesRecord= gson.fromJson(message, PimesRecord.class);
        primesHistoryRepository.save(primesRecord);
    }

}
