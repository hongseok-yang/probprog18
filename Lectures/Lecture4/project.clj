(defproject anglican-user "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [nstools "0.2.4"]
                 [anglican "1.0.0"] 
                 [org.nfrac/cljbox2d.testbed "0.5.0"] 
                 [org.nfrac/cljbox2d "0.5.0"] 
                 [org.clojure/data.priority-map "0.0.7"] 
                 [net.mikera/core.matrix "0.33.2"] 
                 [net.mikera/core.matrix.stats "0.5.0"] 
                 [net.mikera/vectorz-clj "0.29.0"]]
  :plugins [[dtolpin/lein-gorilla "0.3.7-SNAPSHOT"]]
  :resource-paths ["programs"]
  :main ^:skip-aot anglican.core)
