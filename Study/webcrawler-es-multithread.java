/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        ExecutorService es = Executors.newFixedThreadPool(6, l -> {
            Thread t = new Thread(l);
            t.setDaemon(true);
            return t;
        });
            
        Set<String> visited = new HashSet();
       
        Queue<Future<List<String>>> q = new LinkedList<>();
        String hostname = startUrl.indexOf('/', 7) == -1 ? startUrl : startUrl.substring(0,startUrl.indexOf('/', 7));
        q.add(es.submit(() -> htmlParser.getUrls(startUrl)));
        visited.add(startUrl); 

        try{

            while(!q.isEmpty()){

                List<String> listOfValidSites = q.poll().get().stream().filter(f -> f.startsWith(hostname)).collect(Collectors.toList());

                for(String site : listOfValidSites){
                    if(visited.contains(site)){
                        continue;
                    }
                    visited.add(site);
                    q.add(es.submit(() -> htmlParser.getUrls(site)));
                }
            }
        }catch(Exception e){
            
        }
        
        return new ArrayList<String>(visited);
    }
}