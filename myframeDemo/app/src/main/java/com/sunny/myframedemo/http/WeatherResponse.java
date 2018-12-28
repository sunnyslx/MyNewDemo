package com.sunny.myframedemo.http;

import java.util.List;

/**
 * Created by Sunny on 18-12-14.
 */

public class WeatherResponse {

    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101020100","location":"上海","parent_city":"上海","admin_area":"上海","cnty":"中国","lat":"31.23170662","lon":"121.47264099","tz":"+8.00"}
         * update : {"loc":"2018-12-14 13:45","utc":"2018-12-14 05:45"}
         * status : ok
         * now : {"cloud":"0","cond_code":"101","cond_txt":"多云","fl":"8","hum":"53","pcpn":"0.0","pres":"1033","tmp":"10","vis":"10","wind_deg":"83","wind_dir":"东风","wind_sc":"1","wind_spd":"4"}
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-12-14","hum":"65","mr":"11:34","ms":"22:58","pcpn":"0.0","pop":"3","pres":"1035","sr":"06:45","ss":"16:53","tmp_max":"9","tmp_min":"4","uv_index":"0","vis":"20","wind_deg":"5","wind_dir":"北风","wind_sc":"1-2","wind_spd":"6"},{"cond_code_d":"104","cond_code_n":"305","cond_txt_d":"阴","cond_txt_n":"小雨","date":"2018-12-15","hum":"67","mr":"12:07","ms":"23:52","pcpn":"5.0","pop":"80","pres":"1032","sr":"06:45","ss":"16:53","tmp_max":"11","tmp_min":"7","uv_index":"1","vis":"20","wind_deg":"101","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"1"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2018-12-16","hum":"83","mr":"12:38","ms":"00:00","pcpn":"0.0","pop":"25","pres":"1026","sr":"06:46","ss":"16:53","tmp_max":"11","tmp_min":"5","uv_index":"3","vis":"15","wind_deg":"289","wind_dir":"西北风","wind_sc":"3-4","wind_spd":"24"},{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2018-12-17","hum":"46","mr":"13:11","ms":"00:47","pcpn":"0.0","pop":"0","pres":"1027","sr":"06:47","ss":"16:54","tmp_max":"11","tmp_min":"4","uv_index":"5","vis":"20","wind_deg":"161","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"9"},{"cond_code_d":"100","cond_code_n":"101","cond_txt_d":"晴","cond_txt_n":"多云","date":"2018-12-18","hum":"46","mr":"13:44","ms":"01:43","pcpn":"0.0","pop":"0","pres":"1025","sr":"06:47","ss":"16:54","tmp_max":"14","tmp_min":"8","uv_index":"3","vis":"20","wind_deg":"189","wind_dir":"南风","wind_sc":"1-2","wind_spd":"3"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-12-19","hum":"70","mr":"14:20","ms":"02:42","pcpn":"0.0","pop":"7","pres":"1023","sr":"06:48","ss":"16:55","tmp_max":"14","tmp_min":"9","uv_index":"2","vis":"20","wind_deg":"87","wind_dir":"东风","wind_sc":"1-2","wind_spd":"7"},{"cond_code_d":"305","cond_code_n":"307","cond_txt_d":"小雨","cond_txt_n":"大雨","date":"2018-12-20","hum":"89","mr":"15:00","ms":"03:43","pcpn":"7.0","pop":"71","pres":"1022","sr":"06:48","ss":"16:55","tmp_max":"14","tmp_min":"8","uv_index":"1","vis":"8","wind_deg":"302","wind_dir":"西北风","wind_sc":"1-2","wind_spd":"4"}]
         * hourly : [{"cloud":"83","cond_code":"101","cond_txt":"多云","dew":"-1","hum":"70","pop":"0","pres":"1031","time":"2018-12-14 16:00","tmp":"8","wind_deg":"28","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"11"},{"cloud":"62","cond_code":"101","cond_txt":"多云","dew":"0","hum":"74","pop":"0","pres":"1031","time":"2018-12-14 19:00","tmp":"7","wind_deg":"28","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"4"},{"cloud":"45","cond_code":"101","cond_txt":"多云","dew":"1","hum":"80","pop":"0","pres":"1030","time":"2018-12-14 22:00","tmp":"6","wind_deg":"73","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"8"},{"cloud":"23","cond_code":"101","cond_txt":"多云","dew":"1","hum":"84","pop":"0","pres":"1032","time":"2018-12-15 01:00","tmp":"5","wind_deg":"36","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"10","cond_code":"101","cond_txt":"多云","dew":"2","hum":"85","pop":"0","pres":"1031","time":"2018-12-15 04:00","tmp":"5","wind_deg":"32","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"18","cond_code":"101","cond_txt":"多云","dew":"3","hum":"80","pop":"1","pres":"1030","time":"2018-12-15 07:00","tmp":"6","wind_deg":"52","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"9"},{"cloud":"53","cond_code":"104","cond_txt":"阴","dew":"0","hum":"76","pop":"4","pres":"1030","time":"2018-12-15 10:00","tmp":"8","wind_deg":"86","wind_dir":"东风","wind_sc":"1-2","wind_spd":"11"},{"cloud":"89","cond_code":"104","cond_txt":"阴","dew":"0","hum":"75","pop":"7","pres":"1028","time":"2018-12-15 13:00","tmp":"10","wind_deg":"82","wind_dir":"东风","wind_sc":"1-2","wind_spd":"7"}]
         * lifestyle : [{"type":"comf","brf":"较舒适","txt":"白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"},{"type":"drsg","brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},{"type":"flu","brf":"较易发","txt":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。"},{"type":"sport","brf":"较适宜","txt":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"},{"type":"trav","brf":"适宜","txt":"天气较好，同时又有微风伴您一路同行。虽会让人感觉有点凉，但仍适宜旅游，可不要错过机会呦！"},{"type":"uv","brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"},{"type":"cw","brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},{"type":"air","brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyBean> hourly;
        private List<LifestyleBean> lifestyle;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
        }

        public static class BasicBean {
            /**
             * cid : CN101020100
             * location : 上海
             * parent_city : 上海
             * admin_area : 上海
             * cnty : 中国
             * lat : 31.23170662
             * lon : 121.47264099
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2018-12-14 13:45
             * utc : 2018-12-14 05:45
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowBean {
            /**
             * cloud : 0
             * cond_code : 101
             * cond_txt : 多云
             * fl : 8
             * hum : 53
             * pcpn : 0.0
             * pres : 1033
             * tmp : 10
             * vis : 10
             * wind_deg : 83
             * wind_dir : 东风
             * wind_sc : 1
             * wind_spd : 4
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class DailyForecastBean {
            /**
             * cond_code_d : 101
             * cond_code_n : 101
             * cond_txt_d : 多云
             * cond_txt_n : 多云
             * date : 2018-12-14
             * hum : 65
             * mr : 11:34
             * ms : 22:58
             * pcpn : 0.0
             * pop : 3
             * pres : 1035
             * sr : 06:45
             * ss : 16:53
             * tmp_max : 9
             * tmp_min : 4
             * uv_index : 0
             * vis : 20
             * wind_deg : 5
             * wind_dir : 北风
             * wind_sc : 1-2
             * wind_spd : 6
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class HourlyBean {
            /**
             * cloud : 83
             * cond_code : 101
             * cond_txt : 多云
             * dew : -1
             * hum : 70
             * pop : 0
             * pres : 1031
             * time : 2018-12-14 16:00
             * tmp : 8
             * wind_deg : 28
             * wind_dir : 东北风
             * wind_sc : 1-2
             * wind_spd : 11
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String dew;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getDew() {
                return dew;
            }

            public void setDew(String dew) {
                this.dew = dew;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class LifestyleBean {
            /**
             * type : comf
             * brf : 较舒适
             * txt : 白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。
             */

            private String type;
            private String brf;
            private String txt;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }
}
