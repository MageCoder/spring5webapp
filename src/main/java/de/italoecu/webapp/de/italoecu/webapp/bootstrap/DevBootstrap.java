package de.italoecu.webapp.de.italoecu.webapp.bootstrap;

import de.italoecu.webapp.de.italoecu.webapp.model.Brand;
import de.italoecu.webapp.de.italoecu.webapp.model.Country;
import de.italoecu.webapp.de.italoecu.webapp.model.Model;
import de.italoecu.webapp.de.italoecu.webapp.repositories.BrandRepository;
import de.italoecu.webapp.de.italoecu.webapp.repositories.CountryRepository;
import de.italoecu.webapp.de.italoecu.webapp.repositories.ModelRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BrandRepository brandRepository;
    private ModelRepository modelRepository;
    private CountryRepository countryRepository;

    public DevBootstrap(BrandRepository brandRepository, ModelRepository modelRepository, CountryRepository countryRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }


    private void initData(){

        Country italy = new Country("Italien", "IT");
        countryRepository.save(italy);

        Country germany = new Country("Deutschland", "DE");
        countryRepository.save(germany);

        Country austria = new Country("Österreich", "AUT");
        countryRepository.save(austria);

        // new brand
        Brand alfaRomeo = new Brand("Alfa Romeo", italy, 1910);
        brandRepository.save(alfaRomeo);

        Brand maserati = new Brand("Maserati", italy, 1910);
        brandRepository.save(maserati);

        // new model
        Model giulietta = new Model("Alfa Romeo Giulietta", "2011-2018", alfaRomeo);
        modelRepository.save(giulietta);

        // add model to brand
        alfaRomeo.getModels().add(giulietta);
        brandRepository.save(alfaRomeo);


    }
}
