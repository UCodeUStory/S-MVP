package com.wangpos.s_mvp.bean;

/**
 * Created by qiyue on 2018/7/3.
 */

public class JHWeatherResult {
    /**
     * resultcode : 200
     * reason : 查询成功
     * result : {"sk":{"temp":"28","wind_direction":"西风","wind_strength":"2级","humidity":"92%","time":"13:30"},"today":{"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","city":"池州","date_y":"2018年07月03日","dressing_index":"热","dressing_advice":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""},"future":{"day_20180703":{"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","date":"20180703"},"day_20180704":{"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期三","date":"20180704"},"day_20180705":{"temperature":"26℃~34℃","weather":"雷阵雨转中雨","weather_id":{"fa":"04","fb":"08"},"wind":"南风3-5级","week":"星期四","date":"20180705"},"day_20180706":{"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期五","date":"20180706"},"day_20180707":{"temperature":"24℃~28℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"西北风微风","week":"星期六","date":"20180707"},"day_20180708":{"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期日","date":"20180708"},"day_20180709":{"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期一","date":"20180709"}}}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * sk : {"temp":"28","wind_direction":"西风","wind_strength":"2级","humidity":"92%","time":"13:30"}
         * today : {"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","city":"池州","date_y":"2018年07月03日","dressing_index":"热","dressing_advice":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","uv_index":"弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""}
         * future : {"day_20180703":{"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","date":"20180703"},"day_20180704":{"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期三","date":"20180704"},"day_20180705":{"temperature":"26℃~34℃","weather":"雷阵雨转中雨","weather_id":{"fa":"04","fb":"08"},"wind":"南风3-5级","week":"星期四","date":"20180705"},"day_20180706":{"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期五","date":"20180706"},"day_20180707":{"temperature":"24℃~28℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"西北风微风","week":"星期六","date":"20180707"},"day_20180708":{"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期日","date":"20180708"},"day_20180709":{"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期一","date":"20180709"}}
         */

        private SkBean sk;
        private TodayBean today;
        private FutureBean future;

        public SkBean getSk() {
            return sk;
        }

        public void setSk(SkBean sk) {
            this.sk = sk;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public FutureBean getFuture() {
            return future;
        }

        public void setFuture(FutureBean future) {
            this.future = future;
        }

        public static class SkBean {
            /**
             * temp : 28
             * wind_direction : 西风
             * wind_strength : 2级
             * humidity : 92%
             * time : 13:30
             */

            private String temp;
            private String wind_direction;
            private String wind_strength;
            private String humidity;
            private String time;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class TodayBean {
            /**
             * temperature : 25℃~30℃
             * weather : 中雨
             * weather_id : {"fa":"08","fb":"08"}
             * wind : 北风微风
             * week : 星期二
             * city : 池州
             * date_y : 2018年07月03日
             * dressing_index : 热
             * dressing_advice : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
             * uv_index : 弱
             * comfort_index :
             * wash_index : 不宜
             * travel_index : 较不宜
             * exercise_index : 较不宜
             * drying_index :
             */

            private String temperature;
            private String weather;
            private WeatherIdBean weather_id;
            private String wind;
            private String week;
            private String city;
            private String date_y;
            private String dressing_index;
            private String dressing_advice;
            private String uv_index;
            private String comfort_index;
            private String wash_index;
            private String travel_index;
            private String exercise_index;
            private String drying_index;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBean getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBean weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }

            public static class WeatherIdBean {
                /**
                 * fa : 08
                 * fb : 08
                 */

                private String fa;
                private String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }

        public static class FutureBean {
            /**
             * day_20180703 : {"temperature":"25℃~30℃","weather":"中雨","weather_id":{"fa":"08","fb":"08"},"wind":"北风微风","week":"星期二","date":"20180703"}
             * day_20180704 : {"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期三","date":"20180704"}
             * day_20180705 : {"temperature":"26℃~34℃","weather":"雷阵雨转中雨","weather_id":{"fa":"04","fb":"08"},"wind":"南风3-5级","week":"星期四","date":"20180705"}
             * day_20180706 : {"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期五","date":"20180706"}
             * day_20180707 : {"temperature":"24℃~28℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"西北风微风","week":"星期六","date":"20180707"}
             * day_20180708 : {"temperature":"27℃~32℃","weather":"雷阵雨转多云","weather_id":{"fa":"04","fb":"01"},"wind":"西南风3-5级","week":"星期日","date":"20180708"}
             * day_20180709 : {"temperature":"24℃~32℃","weather":"中雨转小雨","weather_id":{"fa":"08","fb":"07"},"wind":"西南风微风","week":"星期一","date":"20180709"}
             */

            private Day20180703Bean day_20180703;
            private Day20180704Bean day_20180704;
            private Day20180705Bean day_20180705;
            private Day20180706Bean day_20180706;
            private Day20180707Bean day_20180707;
            private Day20180708Bean day_20180708;
            private Day20180709Bean day_20180709;

            public Day20180703Bean getDay_20180703() {
                return day_20180703;
            }

            public void setDay_20180703(Day20180703Bean day_20180703) {
                this.day_20180703 = day_20180703;
            }

            public Day20180704Bean getDay_20180704() {
                return day_20180704;
            }

            public void setDay_20180704(Day20180704Bean day_20180704) {
                this.day_20180704 = day_20180704;
            }

            public Day20180705Bean getDay_20180705() {
                return day_20180705;
            }

            public void setDay_20180705(Day20180705Bean day_20180705) {
                this.day_20180705 = day_20180705;
            }

            public Day20180706Bean getDay_20180706() {
                return day_20180706;
            }

            public void setDay_20180706(Day20180706Bean day_20180706) {
                this.day_20180706 = day_20180706;
            }

            public Day20180707Bean getDay_20180707() {
                return day_20180707;
            }

            public void setDay_20180707(Day20180707Bean day_20180707) {
                this.day_20180707 = day_20180707;
            }

            public Day20180708Bean getDay_20180708() {
                return day_20180708;
            }

            public void setDay_20180708(Day20180708Bean day_20180708) {
                this.day_20180708 = day_20180708;
            }

            public Day20180709Bean getDay_20180709() {
                return day_20180709;
            }

            public void setDay_20180709(Day20180709Bean day_20180709) {
                this.day_20180709 = day_20180709;
            }

            public static class Day20180703Bean {
                /**
                 * temperature : 25℃~30℃
                 * weather : 中雨
                 * weather_id : {"fa":"08","fb":"08"}
                 * wind : 北风微风
                 * week : 星期二
                 * date : 20180703
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanX {
                    /**
                     * fa : 08
                     * fb : 08
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20180704Bean {
                /**
                 * temperature : 27℃~32℃
                 * weather : 雷阵雨转多云
                 * weather_id : {"fa":"04","fb":"01"}
                 * wind : 西南风3-5级
                 * week : 星期三
                 * date : 20180704
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXX {
                    /**
                     * fa : 04
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20180705Bean {
                /**
                 * temperature : 26℃~34℃
                 * weather : 雷阵雨转中雨
                 * weather_id : {"fa":"04","fb":"08"}
                 * wind : 南风3-5级
                 * week : 星期四
                 * date : 20180705
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXX {
                    /**
                     * fa : 04
                     * fb : 08
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20180706Bean {
                /**
                 * temperature : 24℃~32℃
                 * weather : 中雨转小雨
                 * weather_id : {"fa":"08","fb":"07"}
                 * wind : 西南风微风
                 * week : 星期五
                 * date : 20180706
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXX {
                    /**
                     * fa : 08
                     * fb : 07
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20180707Bean {
                /**
                 * temperature : 24℃~28℃
                 * weather : 小雨
                 * weather_id : {"fa":"07","fb":"07"}
                 * wind : 西北风微风
                 * week : 星期六
                 * date : 20180707
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXX {
                    /**
                     * fa : 07
                     * fb : 07
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20180708Bean {
                /**
                 * temperature : 27℃~32℃
                 * weather : 雷阵雨转多云
                 * weather_id : {"fa":"04","fb":"01"}
                 * wind : 西南风3-5级
                 * week : 星期日
                 * date : 20180708
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXX {
                    /**
                     * fa : 04
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20180709Bean {
                /**
                 * temperature : 24℃~32℃
                 * weather : 中雨转小雨
                 * weather_id : {"fa":"08","fb":"07"}
                 * wind : 西南风微风
                 * week : 星期一
                 * date : 20180709
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXXX {
                    /**
                     * fa : 08
                     * fb : 07
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }
        }
    }
}
