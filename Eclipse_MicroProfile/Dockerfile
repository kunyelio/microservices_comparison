FROM open-liberty
RUN ln -s /opt/ol/wlp/usr/servers /servers
RUN ln -s /opt/ol/wlp/usr/shared/resources /resources
ENTRYPOINT ["/opt/ol/wlp/bin/server", "run"]
CMD ["defaultServer"]
