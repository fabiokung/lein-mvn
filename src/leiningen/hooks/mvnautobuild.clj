(ns leiningen.hooks.mvnautobuild
  (use robert.hooke)
  (require leiningen.deps)
  (require leiningen.mvn))

(defn- mvn-deps [task & args]
  (apply task args)
  (leiningen.mvn/mvn (first args) "package" "-DskipTests=true"))

(add-hook #'leiningen.deps/deps mvn-deps)

