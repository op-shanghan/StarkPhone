package com.stark.app.tools.model

import org.springframework.data.annotation.Id

/**
 * 城市模型
 */
class CityModel implements Serializable {
    @Id
    String id
    /**城市编号**/
    String cityId
    /**城市名称**/
    String cityName
    /**父级编号**/
    String fCityId

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getCityId() {
        return cityId
    }

    void setCityId(String cityId) {
        this.cityId = cityId
    }

    String getCityName() {
        return cityName
    }

    void setCityName(String cityName) {
        this.cityName = cityName
    }

    String getfCityId() {
        return fCityId
    }

    void setfCityId(String fCityId) {
        this.fCityId = fCityId
    }
}
