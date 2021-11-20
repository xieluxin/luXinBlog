package com.luxin.front;

import com.luxin.entity.Channel;
import com.luxin.service.ChannelService;
import com.luxin.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/f/channel")
public class FrontChannelController {
    @Autowired
    private ChannelService channelService;


    @GetMapping("/get")
    public Result get(Integer id){
        if (id==null){
            return Result.fail();
        }
        Channel detail = channelService.detail(id);
        return Result.ok(detail);
    }


    @GetMapping("/queryByPos")
    public Result getChannelByPos(String pos){
        if (StringUtils.isEmpty(pos)){
            return Result.fail();
        }
        List<Channel> channelPos = channelService.getChannelByPos(pos.toUpperCase());
        List<Map<String,Object>> mapList=new ArrayList<>();
        for (Channel channel : channelPos) {
            //首先获取顶级栏目
            if (channel.getParentId()==0){
                Map<String,Object> map =new HashMap<>();
                map.put("id",channel.getId());
                map.put("name",channel.getName());
                if (channel!= null &&"Y".equals(channel.getSingle())){
                    map.put("single",true);
                }
                List<Map<String,Object>> children=new ArrayList<>();
                for (Channel entity : channelPos) {
                    if (entity.getParentId() == channel.getId() ){
                        Map<String,Object> subMap=new HashMap<>();
                        subMap.put("id",entity.getId());
                        subMap.put("name",entity.getName());
                        if (entity!= null &&"Y".equals(entity.getSingle())){
                            map.put("single",true);
                        }
                        children.add(subMap);
                    }
                }
                if (children.size()>0){
                    map.put("children",children);
                }
                mapList.add(map);
            }
        }
        return Result.ok(mapList);
    }
}
