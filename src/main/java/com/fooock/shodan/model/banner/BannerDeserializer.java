/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Newhouse (nhitbh at gmail dot com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.fooock.shodan.model.banner;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BannerDeserializer implements JsonDeserializer<List<Banner>> {

    @Override
    public List<Banner> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        final List<Banner> banners = new ArrayList<>();
        if (json.isJsonNull()) {
            return banners;
        }
        JsonArray jsonArray = json.getAsJsonArray();
        if (jsonArray.isJsonNull()) {
            return banners;
        }
        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            JsonElement port = jsonObject.get("port");
            JsonElement ip = jsonObject.get("ip");
            JsonElement asn = jsonObject.get("asn");
            JsonElement data = jsonObject.get("data");
            JsonElement ipStr = jsonObject.get("ip_str");
            JsonElement ipv6 = jsonObject.get("ipv6");
            JsonElement timestamp = jsonObject.get("timestamp");
            JsonElement hostnames = jsonObject.get("hostnames");
            JsonElement domains = jsonObject.get("domains");
            JsonElement location = jsonObject.get("location");
            JsonElement options = jsonObject.get("opts");
            JsonElement metadata = jsonObject.get("_shodan");

            JsonElement uptime = jsonObject.get("uptime");
            JsonElement link = jsonObject.get("link");
            JsonElement title = jsonObject.get("title");
            JsonElement html = jsonObject.get("html");
            JsonElement product = jsonObject.get("product");
            JsonElement version = jsonObject.get("version");
            JsonElement isp = jsonObject.get("isp");
            JsonElement os = jsonObject.get("os");
            JsonElement transport = jsonObject.get("transport");
            JsonElement devicetype = jsonObject.get("devicetype");
            JsonElement info = jsonObject.get("info");
            JsonElement cpe = jsonObject.get("cpe");

            final Banner banner = new Banner();
            if (port == null || port.isJsonNull()) {
                banner.setPort(0);
            } else {
                banner.setPort(port.getAsInt());
            }

            if (ip == null || ip.isJsonNull()) {
                banner.setIp(0);
            } else {
                banner.setIp(ip.getAsLong());
            }

            if (asn == null || asn.isJsonNull()) {
                banner.setAsn("unknown");
            } else {
                banner.setAsn(asn.getAsString());
            }

            if (data == null || data.isJsonNull()) {
                banner.setData("unknown");
            } else {
                banner.setData(data.getAsString());
            }

            if (ipStr == null || ipStr.isJsonNull()) {
                banner.setIpStr("unknown");
            } else {
                banner.setIpStr(ipStr.getAsString());
            }

            if (ipv6 == null || ipv6.isJsonNull()) {
                banner.setIpv6("unknown");
            } else {
                banner.setIpv6(ipv6.getAsString());
            }

            if (timestamp == null || timestamp.isJsonNull()) {
                banner.setTimestamp("unknown");
            } else {
                banner.setTimestamp(timestamp.getAsString());
            }

            if (hostnames == null || hostnames.isJsonNull()) {
                banner.setHostnames(new String[0]);
            } else {
                JsonArray hostnamesAsJsonArray = hostnames.getAsJsonArray();
                String[] hostnameArray = new String[hostnamesAsJsonArray.size()];
                for (int i = 0; i < hostnamesAsJsonArray.size(); i++) {
                    hostnameArray[i] = hostnamesAsJsonArray.get(i).getAsString();
                }
                banner.setHostnames(hostnameArray);
            }

            if (domains == null || domains.isJsonNull()) {
                banner.setDomains(new String[0]);
            } else {
                JsonArray domainsAsJsonArray = domains.getAsJsonArray();
                String[] domainsArray = new String[domainsAsJsonArray.size()];
                for (int i = 0; i < domainsAsJsonArray.size(); i++) {
                    domainsArray[i] = domainsAsJsonArray.get(i).getAsString();
                }
                banner.setDomains(domainsArray);
            }

            if (location == null || location.isJsonNull()) {
                banner.setLocation(new Location());
            } else {
                JsonObject locationAsJsonObject = location.getAsJsonObject();
                JsonElement areaCode = locationAsJsonObject.get("area_code");
                JsonElement latitude = locationAsJsonObject.get("latitude");
                JsonElement longitude = locationAsJsonObject.get("longitude");
                JsonElement city = locationAsJsonObject.get("city");
                JsonElement regionCode = locationAsJsonObject.get("region_code");
                JsonElement postalCode = locationAsJsonObject.get("postal_code");
                JsonElement dmaCode = locationAsJsonObject.get("dma_code");
                JsonElement countryCode = locationAsJsonObject.get("country_code");
                JsonElement countryCode3 = locationAsJsonObject.get("country_code3");
                JsonElement countryName = locationAsJsonObject.get("country_name");

                Location locationObject = new Location();
                if (areaCode == null || areaCode.isJsonNull()) {
                    locationObject.setAreaCode(0);
                } else {
                    locationObject.setAreaCode(areaCode.getAsInt());
                }

                if (latitude == null || latitude.isJsonNull()) {
                    locationObject.setLatitude(0.0);
                } else {
                    locationObject.setLatitude(latitude.getAsDouble());
                }

                if (longitude == null || location.isJsonNull()) {
                    locationObject.setLongitude(0.0);
                } else {
                    locationObject.setLongitude(longitude.getAsDouble());
                }

                if (city == null || city.isJsonNull()) {
                    locationObject.setCity("unknown");
                } else {
                    locationObject.setCity(city.getAsString());
                }

                if (regionCode == null || regionCode.isJsonNull()) {
                    locationObject.setRegionCode("unknown");
                } else {
                    locationObject.setRegionCode(regionCode.getAsString());
                }

                if (postalCode == null || postalCode.isJsonNull()) {
                    locationObject.setPostalCode("unknown");
                } else {
                    locationObject.setPostalCode(postalCode.getAsString());
                }

                if (dmaCode == null || dmaCode.isJsonNull()) {
                    locationObject.setDmaCode("unknown");
                } else {
                    locationObject.setDmaCode(dmaCode.getAsString());
                }

                if (countryCode == null || countryCode.isJsonNull()) {
                    locationObject.setCountryCode("unknown");
                } else {
                    locationObject.setCountryCode(countryCode.getAsString());
                }

                if (countryCode3 == null || countryCode3.isJsonNull()) {
                    locationObject.setCountryCode3("unknown");
                } else {
                    locationObject.setCountryCode3(countryCode3.getAsString());
                }

                if (countryName == null || countryName.isJsonNull()) {
                    locationObject.setCountryName("unknown");
                } else {
                    locationObject.setCountryName(countryName.getAsString());
                }

                banner.setLocation(locationObject);
            }

            final Options opts = new Options();
            if (options == null || options.isJsonNull()) {
                opts.setRaw("unknown");
            } else {
                JsonObject object = options.getAsJsonObject();
                JsonElement raw = object.get("raw");
                if (raw == null || raw.isJsonNull()) {
                    opts.setRaw("unknown");
                } else {
                    opts.setRaw(raw.getAsString());
                }
            }
            banner.setOptions(opts);

            final Metadata shodanMetadata = new Metadata();
            if (metadata == null || metadata.isJsonNull()) {
                shodanMetadata.setCrawler("unknown");
                shodanMetadata.setId("unknown");
                shodanMetadata.setModule("unknown");
            } else {
                JsonObject metadataAsJsonObject = metadata.getAsJsonObject();
                JsonElement crawler = metadataAsJsonObject.get("crawler");
                JsonElement id = metadataAsJsonObject.get("id");
                JsonElement module = metadataAsJsonObject.get("module");

                if (crawler == null || crawler.isJsonNull()) {
                    shodanMetadata.setCrawler("unknown");
                } else {
                    shodanMetadata.setCrawler(crawler.getAsString());
                }

                if (id == null || id.isJsonNull()) {
                    shodanMetadata.setId("unknown");
                } else {
                    shodanMetadata.setId(id.getAsString());
                }

                if (module == null || module.isJsonNull()) {
                    shodanMetadata.setModule("unknown");
                } else {
                    shodanMetadata.setModule(module.getAsString());
                }
            }
            banner.setMetadata(shodanMetadata);

            if (uptime == null || uptime.isJsonNull()) {
                banner.setUptime(0);
            } else {
                banner.setUptime(uptime.getAsInt());
            }

            if (link == null || link.isJsonNull()) {
                banner.setLink("unknown");
            } else {
                banner.setLink(link.getAsString());
            }

            if (title == null || title.isJsonNull()) {
                banner.setTitle("unknown");
            } else {
                banner.setTitle(title.getAsString());
            }

            if (html == null || html.isJsonNull()) {
                banner.setHtml("unknown");
            } else {
                banner.setHtml(html.getAsString());
            }

            if (product == null || product.isJsonNull()) {
                banner.setProduct("unknown");
            } else {
                banner.setProduct(product.getAsString());
            }

            if (version == null || version.isJsonNull()) {
                banner.setVersion("unknown");
            } else {
                banner.setVersion(version.getAsString());
            }

            if (isp == null || isp.isJsonNull()) {
                banner.setIsp("unknown");
            } else {
                banner.setIsp(isp.getAsString());
            }

            if (os == null || os.isJsonNull()) {
                banner.setOs("unknown");
            } else {
                banner.setOs(os.getAsString());
            }

            if (transport == null || transport.isJsonNull()) {
                banner.setTransport("unknown");
            } else {
                banner.setTransport(transport.getAsString());
            }

            if (devicetype == null || devicetype.isJsonNull()) {
                banner.setDeviceType("unknown");
            } else {
                banner.setDeviceType(devicetype.getAsString());
            }

            if (info == null || info.isJsonNull()) {
                banner.setInfo("unknown");
            } else {
                banner.setInfo(info.getAsString());
            }

            if (cpe == null || cpe.isJsonNull()) {
                banner.setCpe(new String[0]);
            } else {
                // cpe can be string or string[]. Fix for #4
                if (cpe.isJsonObject()) {
                    banner.setCpe(new String[]{cpe.getAsString()});

                } else {
                    JsonArray cpeAsJsonArray = cpe.getAsJsonArray();
                    String[] cpeArray = new String[cpeAsJsonArray.size()];
                    for (int i = 0; i < cpeAsJsonArray.size(); i++) {
                        cpeArray[i] = cpeAsJsonArray.get(i).getAsString();
                    }
                    banner.setCpe(cpeArray);
                }
            }

            banners.add(banner);
        }
        return banners;
    }
}
