package de.italoecu.webapp.de.italoecu.webapp.bootstrap;

import de.italoecu.webapp.de.italoecu.webapp.model.Brand;
import de.italoecu.webapp.de.italoecu.webapp.model.CarType;
import de.italoecu.webapp.de.italoecu.webapp.model.Country;
import de.italoecu.webapp.de.italoecu.webapp.model.Model;
import de.italoecu.webapp.de.italoecu.webapp.repositories.BrandRepository;
import de.italoecu.webapp.de.italoecu.webapp.repositories.CarTypeRepository;
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
    private CarTypeRepository carTypeRepository;

    public DevBootstrap(BrandRepository brandRepository, ModelRepository modelRepository, CountryRepository countryRepository, CarTypeRepository carTypeRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.countryRepository = countryRepository;
        this.carTypeRepository = carTypeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }


    private void initData(){

        // new car types
        CarType limo = new CarType("Limousine");
        carTypeRepository.save(limo);

        CarType kombi = new CarType("Kombi");
        carTypeRepository.save(kombi);

        CarType kabrio = new CarType("Kabriolet");
        carTypeRepository.save(kabrio);

        CarType coupe = new CarType("Coupe");
        carTypeRepository.save(coupe);

        CarType kompakt = new CarType("Kompaktklasse");
        carTypeRepository.save(kompakt);



        // new countries
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
        Model giulietta = new Model("Alfa Romeo Giulietta", "2011-2018", alfaRomeo, kompakt);
        modelRepository.save(giulietta);

        // add model to brand
        alfaRomeo.getModels().add(giulietta);
        brandRepository.save(alfaRomeo);


    }
}
