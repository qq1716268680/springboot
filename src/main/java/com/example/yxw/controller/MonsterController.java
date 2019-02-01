package com.example.yxw.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.yxw.domain.Monster;
import com.example.yxw.service.MonsterService;
import com.example.yxw.util.Result;
import com.example.yxw.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MonsterController {


    @Autowired
    private MonsterService monsterService;

    @RequestMapping("/listMonster")
    public Result listMonster(HttpServletRequest request) {

        List list = monsterService.listAll();
        return ResultUtil.success(request,list);
    }

    @RequestMapping("/addMonster")
    public ModelAndView getIndex() {
        /*String s = "{'cards':[{'id':'1262','hash_id':'ZXsv2','password':'23995346'," +
                "'name':'蓝眼究极龙','name_ja':'青眼の究極竜','name_en':" +
                "'Blue-Eyes Ultimate Dragon','locale':'3'," +
                "'type_st':'怪兽|融合','type_val':'1'," +
                "'img_url':'http://ocg.resource.m2v.cn/1262.jpg'," +
                "'level':'12','attribute':'光','race':'龙','atk':'4500'," +
                "'def':'3800','pend_l':null,'pend_r':null,'link':null,'link_arrow':null," +
                "'name_nw':'青眼究极龙','desc':'「青眼の白龍／蓝眼白龙」+「青眼の白龍／蓝眼白龙」+「青眼の白龍／蓝眼白龙」'," +
                "'desc_nw':'融合：「青眼白龙」＋「青眼白龙」＋「青眼白龙」。'," +
                "'rare':'面闪SR，立体UTR，黄金GR，斜碎SCR，金字UR'," +
                "'package':'PP03，GLD01，DPKB，KA','href':'https://www.ourocg.cn/card/ZXsv2'}," +
                "{'id':'7630','hash_id':'o0sQBa','password':'56532353','name':'真蓝眼究极龙','name_ja':'真青眼の究極竜'," +
                "'name_en':'Neo Blue-Eyes Ultimate Dragon','locale':'3','type_st':'怪兽|效果|融合','type_val':'1'," +
                "'img_url':'http://ocg.resource.m2v.cn/7630.jpg'," +
                "'level':'12','attribute':'光','race':'龙','atk':'4500','def':'3800','pend_l':null,'pend_r':null," +
                "'link':null,'link_arrow':null,'name_nw':'真青眼究极龙'," +
                "'desc':'「青眼の白龍／蓝眼白龙」+「青眼の白龍／蓝眼白龙」+「青眼の白龍／蓝眼白龙」n「真青眼の究極竜／真蓝眼究极龙」的①效果1回合最多可以使用2次。①：融合召唤的这张卡攻击的伤害步骤结束时，自己场上的表侧表示的卡只有这张卡的场合，可以从额外卡组将1只「ブルーアイズ／蓝眼」融合怪兽送入墓地发动。这张卡可以继续攻击。②：以自己场上的「ブルーアイズ／蓝眼」怪兽为对象的魔法、陷阱或怪兽的效果发动时，可以将墓地的这张卡除外发动。使其效果无效并破坏。','desc_nw':'效果·融合：「青眼白龙」＋「青眼白龙」＋「青眼白龙」rn「真青眼究极龙」的①的效果1回合可以使用最多2次。①：融合召唤的这张卡攻击的伤害步骤结束时，自己场上的表侧表示的卡只有这张卡的场合，从额外卡组把1只「青眼」融合怪兽送去墓地才能发动。这张卡可以继续攻击。②：自己场上的「青眼」怪兽为对象的魔法·陷阱·怪兽的效果发动时，把墓地的这张卡除外才能发动。那个发动无效并破坏。','rare':'海马金字UKC','package':'MVP1','href':'https://www.ourocg.cn/card/o0sQBa'},{'id':'7480','hash_id':'ZXsE0J','password':'38517737','name':'蓝眼亚白龙','name_ja':'青眼の亜白龍','name_en':'Blue-Eyes Alternative White Dragon','locale':'3','type_st':'怪兽|效果|特殊召唤','type_val':'1','img_url':'http://ocg.resource.m2v.cn/7480.jpg','level':'8','attribute':'光','race':'龙','atk':'3000','def':'2500','pend_l':null,'pend_r':null,'link':null,'link_arrow':null,'name_nw':'青眼亚白龙','desc':'这张卡不能通常召唤。向对手展示手牌的1只「青眼の白龍／蓝眼白龙」的场合可以特殊召唤。「青眼の亜白龍／蓝眼亚白龙」的以这个方法所作的特殊召唤1回合只能1次。①：这张卡只要在场上或墓地存在卡名就当作「青眼の白龍／蓝眼白龙」使用。②：1回合1次，可以以对手场上的1只怪兽为对象发动。将那只怪兽破坏。这个效果发动的回合，这张卡不能攻击。','desc_nw':'效果·特殊召唤：这张卡不能通常召唤。把手卡1只「青眼白龙」给对方观看的场合可以特殊召唤。这个方法的「青眼亚白龙」的特殊召唤1回合只能有1次。①：这张卡的卡名只要在场上·墓地存在当作「青眼白龙」使用。②：1回合1次，以对方场上1只怪兽为对象才能发动。那只怪兽破坏。这个效果发动的回合，这张卡不能攻击。','rare':'海马银字RKC','package':'MVPC','href':'https://www.ourocg.cn/card/ZXsE0J'},{'id':'1560','hash_id':'wvsYX','password':'53347303','name':'蓝眼光龙','name_ja':'青眼の光龍','name_en':'Blue-Eyes Shining Dragon','locale':'3','type_st':'怪兽|效果','type_val':'1','img_url':'http://ocg.resource.m2v.cn/1560.jpg','level':'10','attribute':'光','race':'龙','atk':'3000','def':'2500','pend_l':null,'pend_r':null," +
                "'link':null,'link_arrow':null,'name_nw':'青眼光龙','desc':'这张卡不能通常召唤。只有将自己场上的1只「青眼の究極竜／蓝眼究极龙」解放的场合才能特殊召唤。①：这张卡的攻击力上升自己墓地的龙族怪兽数量×300。②：以这张卡为对象的魔法、陷阱或怪兽的效果发动时可以发动。使其效果无效。','desc_nw':'这张卡不能通常召唤。把自己场上1只「青眼究极龙」解放的场合才能特殊召唤。①：这张卡的攻击力上升自己墓地的龙族怪兽数量×300。②：以这张卡为对象的魔法·陷阱·怪兽的效果发动时才能发动。那个效果无效。','rare':'金字UR，平卡N','package':'VB07','href':'https://www.ourocg.cn/card/wvsYX'},{'id':'2301','hash_id':'eXsn8Z','password':'35282433','name':'蓝目银僵尸','name_ja':'青眼の銀ゾンビ','name_en':'Blue-Eyed Silver Zombie','locale':'3','type_st':'怪兽|通常','type_val':'1'," +
                "'img_url':'http://ocg.resource.m2v.cn/2301.jpg','level':'3','attribute':'暗','race':'不死','atk':'900','def':'700','pend_l':null,'pend_r':null,'link':null,'link_arrow':null,'name_nw':'青眼银僵尸','desc':'据说从眼中射出的怪光线能把对手变成僵尸。','desc_nw':'非青眼·描述：据说可以从眼睛里射出怪异的光线，据说能让对方变成僵尸。','rare':'平卡N','package':'VOL02','href':'https://www.ourocg.cn/card/eXsn8Z'},{'id':'9079','hash_id':'3zse07','password':'20654247','name':'蓝眼混沌龙','name_ja':'青眼の混沌龍','name_en':null,'locale':'1','type_st':'怪兽|效果|仪式','type_val':'1','img_url':'http://ocg.resource.m2v.cn/9079.jpg','level':'8','attribute':'暗','race':'龙','atk':'3000','def':'0','pend_l':null,'pend_r':null,'link':null,'link_arrow':null,'name_nw':'青眼混沌龙','desc':'藉由「カオス・フォーム／混沌形成」降临。这张卡只能用仪式召唤来特殊召唤。n①：这张卡不会成为对手的效果的对象，不会被对手的效果破坏。②：使用「青眼の白龍／蓝眼白龙」来仪式召唤的这张卡的攻击宣言时可以发动。变更对手场上全部怪兽的表示形式。被这个效果变更表示形式的怪兽的攻击力、守备力变为0。这个回合，这张卡攻击守备表示怪兽的场合，给予其攻击力超过那个守备力的数值的战斗伤害。','desc_nw':'「混沌形态」降临。这张卡不用仪式召唤不能特殊召唤。rn①：这张卡不会成为对方的效果的对象，不会被对方的效果破坏。rn②：使用「青眼白龙」作仪式召唤的这张卡的攻击宣言时才能发动。对方场上的全部怪兽的表示形式变更。这个效果让表示形式变更的怪兽的攻击力·守备力变成0。这个回合，这张卡向守备表示怪兽攻击的场合，给与攻击力超过那个守备力的数值的战斗伤害。','rare':null,'package':null,'href':'https://www.ourocg.cn/card/3zse07'},{'id':'7481','hash_id':'pBsWX5','password':'02129638','name':'蓝眼双爆裂龙','name_ja':'青眼の双爆裂龍','name_en':'Blue-Eyes Twin Burst Dragon','locale':'3','type_st':'怪兽|效果|融合','type_val':'1','img_url':'http://ocg.resource.m2v.cn/7481.jpg','level':'10','attribute':'光','race':'龙','atk':'3000','def':'2500','pend_l':null,'pend_r':null,'link':null,'link_arrow':null,'name_nw':'青眼双爆裂龙','desc':'「青眼の白龍／蓝眼白龙」+「青眼の白龍／蓝眼白龙」n这张卡只有用融合召唤以及以下的方法才能特殊召唤。●将自己场上的上述卡送入墓地的场合可以从额外卡组特殊召唤（不需要「融合」）。①：这张卡不会被战斗破坏。②：这张卡在1次战斗阶段里可以对怪兽作最多2次攻击。③：这张卡用战斗没能将对手怪兽破坏的伤害步骤结束时可以发动。将那只对手怪兽除外。','desc_nw':'效果·融合：「青眼白龙」＋「青眼白龙」rn这张卡用融合召唤以及以下方法才能特殊召唤。●把自己的怪兽区域的上记卡送去墓地的场合可以从额外卡组特殊召唤（不需要「融合」）。①：这张卡不会被战斗破坏。②：这张卡在同1次的战斗阶段中最多2次可以向怪兽攻击。③：这张卡的攻击没让对方怪兽被破坏的伤害步骤结束时才能发动。那只对方怪兽除外。','rare':'海马银字RKC','package':'VJMP','href':'https://www.ourocg.cn/card/pBsWX5'},{'id':'7533','hash_id':'Kms0VX','password':'59822133','name':'蓝眼精灵龙','name_ja':'青眼の精霊龍','name_en':'Blue-Eyes Spirit Dragon','locale':'3','type_st':'怪兽|效果|同调','type_val':'1','img_url':'http://ocg.resource.m2v.cn/7533.jpg','level':'9','attribute':'光','race':'龙','atk':'2500','def':'3000','pend_l':null,'pend_r':null,'link':null,'link_arrow':null,'name_nw':'青眼精灵龙','desc':'调整+1只以上调整以外的「ブルーアイズ／蓝眼」怪兽n①：只要这张卡在怪兽区存在，双方不能同时特殊召唤2只以上的怪兽。②：1回合1次，墓地的卡的效果发动时可以发动。使其发动无效。③：可以将同调召唤的这张卡解放发动。从额外卡组以守备表示特殊召唤1只「青眼の精霊龍／蓝眼精灵龙」以外的龙族·光属性的同调怪兽。那只怪兽在这个回合的结束阶段破坏。这个效果在对手的回合也能发动。','desc_nw':'效果·同调：调整＋调整以外的「青眼」怪兽1只以上rn①：只要这张卡在怪兽区域存在，双方不能把2只以上的怪兽同时特殊召唤。②：1回合1次，墓地的卡的效果发动时才能发动。那个发动无效。③：把同调召唤的这张卡解放才能发动。从额外卡组把「青眼精灵龙」以外的1只龙族·光属性的同调怪兽守备表示特殊召唤。那只怪兽在这个回合的结束阶段破坏。这个效果在对方回合也能发动。','rare':'金字UR，立体UTR，银碎SER','package':'SHVI(908)','href':'https://www.ourocg.cn/card/Kms0VX'},{'id':'4132','hash_id':'DbsoZ1','password':'09433350','name':'Sin 蓝眼白龙','name_ja':'Sin 青眼の白龍','name_en':'Malefic Blue-Eyes White Dragon','locale':'3','type_st':'怪兽|效果','type_val':'1','img_url':'http://ocg.resource.m2v.cn/4132.jpg','level':'8','attribute':'暗','race':'龙','atk':'3000','def':'2500','pend_l':null,'pend_r':null,'link':null,'link_arrow':null,'name_nw':'罪 青眼白龙','desc':'这张卡不能通常召唤。只有从卡组将1只「青眼の白龍／蓝眼白龙」除外的场合才能特殊召唤。①：「Sin」怪兽在场上只能有1只以表侧表示存在。②：只要这张卡在怪兽区存在，其他的自己的怪兽不能攻击宣言。③：没有场地魔法卡以表侧表示存在的场合这张卡破坏。','desc_nw':'这张卡不能通常召唤。从卡组把1只「青眼白龙」除外的场合可以特殊召唤。名字带有「罪」的怪兽在场上只能有1只表侧表示存在。此外，只要这张卡在场上表侧表示存在，自己的其他怪兽不能攻击宣言。没有场地魔法卡表侧表示存在的场合，这张卡破坏。','rare':'金字UR，银碎SER，平爆NPR','package':'WJMP，DPKB，YMP01，AT03','href':'https://www.ourocg.cn/card/DbsoZ1'},{'id':'139','hash_id':'JMs4P','password':'89631139','name':'蓝眼白龙','name_ja':'青眼の白龍','name_en':'Blue-Eyes White Dragon','locale':'3','type_st':'怪兽|通常','type_val':'1','img_url':'http://ocg.resource.m2v.cn/139.jpg','level':'8','attribute':'光','race':'龙','atk':'3000','def':'2500','pend_l':null,'pend_r':null,'link':null,'link_arrow':null,'name_nw':'青眼白龙'," +
                "'desc':'拥有引以为傲的高攻击力的传说之龙。不管是怎样的对手都能粉碎，其破坏力无法估计。','desc_nw':'描述：以高攻击力著称的传说之龙。任何对手都能粉碎，其破坏力不可估量。','rare':'立体UTR，金字UR，爆闪PR，平卡N，面闪SR','package':'LB，BE01，SM，EX-R(EX)，DL02，Starter Box，DT01，YAP01，DTP01，DPKB，KA，SK2，MFC03，LC01，SD22，SD25，SDKS','href':'https://www.ourocg.cn/card/JMs4P'}],'meta':{'keyword':'青眼','count':33,'total_page':4,'cur_page':1,'suggest':{'text':'相关搜索：','keywords':[]},'title':'搜索 「青眼」','page_type':'search'}}";

        JSONObject j = JSON.parseObject(s);
        JSONArray ja = (JSONArray) j.get("cards");
        for (int i=0;i<ja.size();i++){
            JSONObject obj = (JSONObject) ja.get(i);
            Monster m = new Monster();
            m.setAtk( obj.getInteger("atk"));
            m.setDef( obj.getInteger("def"));
            m.setAttribute(obj.getString("attribute"));
            m.setEffect(obj.getString("desc_nw"));
            m.setId(obj.getString("id"));
            m.setName(obj.getString("name_nw"));
            m.setRace((String) obj.get("race"));
            m.setStar(obj.getInteger("level"));
            m.setImgUrl(obj.getString("img_url"));
            monsterService.insert(m);
        }
*/
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addMonster.html");
        return modelAndView;
    }
}
