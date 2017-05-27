package com.ycb.blog.util;

import com.ycb.blog.common.util.LuceneSearcher;
import com.ycb.blog.common.util.Page;
import com.ycb.blog.dto.SearcherDto;
import org.junit.Test;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-05-27 11:55
 **/

public class LuceneSeacherTest {

    LuceneSearcher luceneSearcher=new LuceneSearcher();

    @Test
    public void test01() {

        SearcherDto searcherDto=new SearcherDto();
        searcherDto.setTitle("中共中央政治局召开会议 审议《关于修改〈中国共产党巡视工作条例〉的决定》和《关于巡视中央意识形态单位情况的专题报告》 中共中央总书记习近平主持会议");
        searcherDto.setDescription("中共中央政治局召开会议 审议《关于修改〈中国共产党巡视工作条例〉的决定》和《关于巡视中央意识形态单位情况的专题报告》 中共中央总书记习近平主持会议");
        searcherDto.setCreated(new Date());
        searcherDto.setUrl("http://127.0.0.1/test");
        searcherDto.setContent("会议指出，党的十八大以来，以习近平同志为核心的党中央把巡视作为推进全面从严治党的重大举措，对加强和改进巡视工作作出一系列重大决策部署，坚持党内监督和群众监督相结合，赋予巡视制度新的活力。实践证明，巡视工作是治标之举，也是治本之策，必须在坚持中深化、在深化中坚持，发挥标本兼治作用。\n" +
                "\n" +
                "　　会议认为，加强巡视工作，必须贯彻党的十八大和十八届三中、四中、五中、六中全会精神，贯彻习近平总书记系列重要讲话精神和治国理政新理念新思想新战略，落实全面从严治党要求，深化政治巡视，聚焦坚持党的领导、加强党的建设、全面从严治党，突出严肃党内政治生活，净化党内政治生态，促进管党治党标本兼治。《条例》修改总结吸纳巡视工作实践创新成果，对中央和国家机关巡视工作、市县巡察工作、一届任期内巡视全覆盖等作出明确规定，为依纪依规开展巡视、推动巡视工作向纵深发展提供了制度保障。");

        searcherDto.setSid(System.currentTimeMillis()+"");

        luceneSearcher.addBean(searcherDto);
    }

    @Test
    public void test02() {

        Page<SearcherDto> page= luceneSearcher.search("加强");

        System.out.println(page.getList().get(0).getContent());



    }


}
