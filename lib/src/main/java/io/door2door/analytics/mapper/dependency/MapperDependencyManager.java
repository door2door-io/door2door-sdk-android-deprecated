package io.door2door.analytics.mapper.dependency;

import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DeviceIdRetriever;
import io.door2door.analytics.mapper.ModelMapper;

/**
 * The type Mapper dependency manager.
 */
public class MapperDependencyManager {

    // external dependencies
    private final InitializationParameters initializationParameters;
    private final DeviceIdRetriever deviceIdRetriever;

    // public dependencies
    private ModelMapper modelMapper;

    /**
     * Instantiates a new Mapper dependency manager.
     *
     * @param initializationParameters the initialization parameters
     * @param deviceIdRetriever        the device id retriever
     */
    public MapperDependencyManager(InitializationParameters initializationParameters,
                                   DeviceIdRetriever deviceIdRetriever) {
        this.initializationParameters = initializationParameters;
        this.deviceIdRetriever = deviceIdRetriever;
    }

    /**
     * Gets model mapper.
     *
     * @return the model mapper
     */
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper(initializationParameters, deviceIdRetriever);
        }
        return modelMapper;
    }
}
