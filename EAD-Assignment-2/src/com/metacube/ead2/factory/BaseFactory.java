package com.metacube.ead2.factory;

import com.metacube.ead2.dao.AdvertisementDao;
import com.metacube.ead2.dao.CategoryDao;
import com.metacube.ead2.facade.AdvertisementFacade;
import com.metacube.ead2.facade.CategoryFacade;

public class BaseFactory {

    /*
     * used to create object of advertisementfacde
     * 
     * @return advertisementfacde object
     */
    public static AdvertisementFacade createAdvertisementFacade() {
        return new AdvertisementFacade();
    }

    /*
     * used to create object of categoryfacde
     * 
     * @return categoryfacde object
     */
    public static CategoryFacade createCategoryFacade() {
        return new CategoryFacade();
    }

    /*
     * used to create object of advertisementdao
     * 
     * @return advertisementdao object
     */
    public static AdvertisementDao createAdvertisementDao() {
        return new AdvertisementDao();
    }

    /*
     * used to create object of categorydao
     * 
     * @return categorydao object
     */
    public static CategoryDao createCategoryDao() {
        return new CategoryDao();
    }
}
