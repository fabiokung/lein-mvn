(ns leiningen.mvn
  (use [lancet.core :only [ant]])
  (use clojure.contrib.str-utils)
  (require clojure.contrib.io)
  (import (org.apache.maven.artifact.ant Mvn)))

(defn mvn [project & arguments]
  (.setBasedir lancet.core/ant-project (:root project))
  (doto (Mvn.)
    (.setProject lancet.core/ant-project)
    (.setArgs (str-join " " arguments))
    (.execute)))

