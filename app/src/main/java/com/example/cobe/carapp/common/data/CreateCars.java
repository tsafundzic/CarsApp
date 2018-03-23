package com.example.cobe.carapp.common.data;

import com.example.cobe.carapp.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobe on 23/03/2018.
 */

public class CreateCars {
    private static List<Car> cars = new ArrayList<>();
    private static List<String> imagesURL = new ArrayList<>();

    public static List<Car> createCars() {

        imagesURL.add("https://raw.githubusercontent.com/tightenco/lambo/master/lambo.jpg");
        imagesURL.add("https://blog.caranddriver.com/wp-content/uploads/2017/05/Huracan_Performante_orange_097-626x383.jpg");
        imagesURL.add("https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/model/one-off/centenario/gallery/centenario.jpg");
        cars.add(new Car(0, "Lambo", "PZ 826 GG", 2018, 350, imagesURL, true));

        imagesURL.clear();
        imagesURL.add("http://fusesdiagram.com/wp-content/uploads/2017/01/ENGolf6-blok1-635x377.jpg");
        cars.add(new Car(1, "Golf 6", "OS 222 BB", 2015, 250, imagesURL, false));

        imagesURL.clear();
        imagesURL.add("http://autonovosti.com/wp-content/uploads/2017/03/DB2016AU00855_small.jpg");
        imagesURL.add("https://auto-mane.com/media/k2/galleries/368/2005_Volkswagen_Golf_1K_Comfortline_5-door_hatchback_2010-05-19.jpg");
        cars.add(new Car(2, "Golf 5", "ZG 555 FF", 2015, 180, imagesURL, false));

        imagesURL.clear();
        imagesURL.add("https://cdn.pocket-lint.com/r/s/970x/assets/images/140090-cars-review-audi-a5-2017-review-image2-3doegrmc6t.jpg");
        cars.add(new Car(3, "Audi A5", "OS 666 GG", 2016, 220, imagesURL, false));

        imagesURL.clear();
        imagesURL.add("https://i.ytimg.com/vi/0XcKb-Ha4Nk/maxresdefault.jpg");
        imagesURL.add("https://www.jutarnji.hr/autoklub/vremeplov/110707-12-skojpg/5718055/alternates/LANDSCAPE_980/110707-12-sko.jpg");
        imagesURL.add("http://www.zagreb.info/wp-content/uploads/2017/04/mfimp-21skoda_favorit_4.jpg");
        cars.add(new Car(5, "Škoda Favorit", "PZ 007 FL", 1980, 100, imagesURL, true));

        imagesURL.clear();
        imagesURL.add("https://autobloggoran.files.wordpress.com/2014/02/yugo6.jpg");
        cars.add(new Car(6, "Yugo 45", "ZG 001 GG", 1988, 80, imagesURL, false));

        return cars;
    }
}
