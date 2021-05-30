// Solution with unlimited threads to completion

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);   
        List<String> result = null;
        
        try{
            Crawler crawler = new Crawler(startUrl, htmlParser, hostname);
            crawler.linkSet = new ConcurrentHashMap<>().newKeySet();
            Thread thread = new Thread(crawler);
            
            thread.start();
            
            thread.join();
            
            result = new ArrayList<>(crawler.linkSet);

        }catch(Exception e){}
        return result;
    }
    
    private String getHostname(String url){
        int index = url.indexOf('/', 7);
        return index == -1 ? url : url.substring(0, index);
    }
}
class Crawler implements Runnable {
        private String url;
        private HtmlParser htmlParser;
        private String hostname;
        
        public static Set<String> linkSet = new ConcurrentHashMap<>().newKeySet();
        
        public Crawler(){};
        
        public Crawler(String url, HtmlParser htmlParser, String hostname){
            this.url = url;
            this.htmlParser = htmlParser;
            this.hostname = hostname;
        };
        
        public Set<String> getSet(){
            return this.linkSet;
        }
        
        @Override
        public void run(){
            try{
                if(url.startsWith(hostname) && !linkSet.contains(url))             
                {

                    linkSet.add(this.url);
                    List<Thread> threads = new ArrayList<>();
                    for (String s : htmlParser.getUrls(url)) {
                        if(linkSet.contains(s)){
                           continue; 
                        } 
                        Crawler crawler = new Crawler(s, htmlParser, hostname);
                        Thread thread = new Thread(crawler);
                        thread.start();
                        threads.add(thread);
                    }
                    for (Thread t : threads) {
                        t.join(); // wait for all threads to complete
                    }
                    

                }
            }catch(Exception e){}
            
            
        }
    }