(def project 'record-parser)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths   #{"test"}
          :dependencies   '[[clj-time/clj-time "0.15.1"]
                            [org.clojure/clojure "1.10.0"]
                            [ring "1.7.1"]
                            [ring/ring-json "0.4.0"]
                            [ring/ring-mock "0.4.0" :scope "test"]
                            [adzerk/boot-test "RELEASE" :scope "test"]])

(task-options!
  aot {:namespace   #{'record-parser.command-line.core}}
  pom {:project     project
       :version     version
       :description "record parser"
       :url         "http://example/FIXME"
       :scm         {:url "https://github.com/yourname/record-parser"}
       :license     {"Eclipse Public License"
                     "http://www.eclipse.org/legal/epl-v10.html"}}
  repl {:init-ns    'record-parser.command-line.core})

(deftask run
  "Run the project."
  [a args ARG [str] "the arguments for the command line application."]
  (with-pass-thru fs
    (require '[record-parser.command-line.core :as app])
    (apply (resolve 'app/-main) args)))

(deftask run-web
  "Run web server"
  [p port PORT int "Server port (default 3000)"]
  (require '[record-parser.web.core :as app])
  (apply (resolve 'app/run-server) [(or port 3000)]))

(require '[adzerk.boot-test :refer [test]])
