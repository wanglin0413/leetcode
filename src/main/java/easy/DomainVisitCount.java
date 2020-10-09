package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        for(String domain: cpdomains){
            int spaceIdx = domain.indexOf(' ');
            int count = Integer.parseInt(domain.substring(0, spaceIdx));
            String subDomain = domain.substring(spaceIdx + 1);
            countMap.put(subDomain, countMap.getOrDefault(subDomain, 0) + count);
            int idx = subDomain.indexOf('.');
            while (idx > 0){
                subDomain = subDomain.substring(idx+ 1);
                countMap.put(subDomain, countMap.getOrDefault(subDomain, 0) + count);
                idx = subDomain.indexOf('.');
            }
        }
        for(Map.Entry entry : countMap.entrySet()){
            StringBuilder oneResult = new StringBuilder();
            oneResult.append(entry.getValue()).append(" ").append(entry.getKey());
            result.add(oneResult.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        DomainVisitCount domainVisitCount = new DomainVisitCount();
        String[] cpDomains = new String[]{"9001 discuss.leetcode.com"};
        System.out.println(domainVisitCount.subdomainVisits(cpDomains));
    }
}
