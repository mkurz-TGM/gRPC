package warehouse;

import org.springframework.stereotype.Service;


@Service
public class WarehouseService {

    public WarehouseData getWarehouseData( String inID ) {
        return new WarehouseSimulation().getData(inID);
    }

}