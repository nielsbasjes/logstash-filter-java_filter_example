#
# AUTOGENERATED DURING BUILD. DO NOT EDIT.
#
# encoding: utf-8
require "logstash/filters/base"
require "logstash/namespace"
require "logstash-filter-FILTER_NAME_jars"
require "java"

class LogStash::Filters::FILTER_CLASS < LogStash::Filters::Base
  config_name "FILTER_NAME"

  def self.javaClass() FILTER_PACKAGE.FILTER_CLASS.java_class; end
end