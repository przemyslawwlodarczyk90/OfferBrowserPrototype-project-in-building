package com.example.offerbrowserprototype.infrastructure.cache;

import com.example.offerbrowserprototype.domain.dto.offer.OfferDTO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(value = "spring.cache.type", havingValue = "redis")
public class OfferCacheFacade {

    private final OfferCacheRetrievalService retrievalService;
    private final OfferCacheStorageService storageService;
    private final OfferCacheDeletionService deletionService;

    public OfferCacheFacade(OfferCacheRetrievalService retrievalService,
                            OfferCacheStorageService storageService,
                            OfferCacheDeletionService deletionService) {
        this.retrievalService = retrievalService;
        this.storageService = storageService;
        this.deletionService = deletionService;
    }

    public List<OfferDTO> getCachedOffers() {
        return retrievalService.getCachedOffers();
    }

    public void cacheOffers(List<OfferDTO> offers) {
        storageService.cacheOffers(offers);
    }

    public void clearCache() {
        deletionService.clearCache();
    }
}
