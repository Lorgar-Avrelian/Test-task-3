package test.task.crptapi.request_filter;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CrptApi {
    private static CrptApi instance;
    private static HashMap<String, List<Long>> controlMap = new HashMap<>();
    private static Long timeInMilliseconds;
    private static int requestLimit;

    public CrptApi() {
    }

    public CrptApi(Long timeInMilliseconds, int requestLimit) {
        this.timeInMilliseconds = timeInMilliseconds;
        this.requestLimit = requestLimit;
    }

    public synchronized boolean control(String signature) {
        if (controlMap.get(signature) == null) {
            controlMap.put(signature, new ArrayList<>(List.of(Clock.systemUTC().millis())));
            return true;
        } else {
            List<Long> timeStamps = controlMap.get(signature);
            Long currentTimeStamp = Clock.systemUTC().millis();
            if (timeStamps.size() < requestLimit) {
                timeStamps.add(currentTimeStamp);
                controlMap.put(signature, timeStamps);
                return true;
            }
            Long latestTimeStamp = timeStamps.stream()
                                             .min(Comparator.comparing(Long::valueOf))
                                             .get();
            if (currentTimeStamp - latestTimeStamp < timeInMilliseconds) {
                timeStamps.remove(latestTimeStamp);
                timeStamps.add(currentTimeStamp);
                controlMap.put(signature, timeStamps);
                return false;
            } else {
                timeStamps.remove(latestTimeStamp);
                timeStamps.add(currentTimeStamp);
                controlMap.put(signature, timeStamps);
                return true;
            }
        }
    }

    public static CrptApi getInstance(Long timeInMilliseconds, int requestLimit) {
        if (instance == null) {
            instance = new CrptApi(timeInMilliseconds, requestLimit);
        }
        return instance;
    }
}
