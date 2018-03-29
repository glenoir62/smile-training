Liferay 7 demo plugins
===========

Docs :

https://dev.liferay.com/zh/develop/tutorials/

Remplacer maven par gradle.

slide 41 Activator (facultatif si on utilise @Component(immediate = true, property = {

}, service = HelloService.class))

Le code est commenté.
Deux façon de faire, annotation ou déclaratif dans un activator.
Le code est commenté dans un activator.

/smile-training/modules/hello-service/src/main/java/fr/smile/training/liferay/service/hello/module/HelloActivator.java

slides 44 -> 45
/smile-training/modules/helloservice-api/src/main/java/fr/smile/training/liferay/service/api/api/HelloService.java

/smile-training/modules/hello-service/src/main/java/fr/smile/training/liferay/service/api/impl/HelloServiceImpl.java

slides 46 -> 47
/smile-training/modules/hello-service/src/main/java/fr/smile/training/liferay/gogo/FormationGOGOCommand.java

slides 48
 /smile-training/modules/hello-service/src/main/java/fr/smile/training/liferay/gogo/FormationGOGOCommand.java

/smile-training/modules/hello-service/src/main/java/fr/smile/training/liferay/service/api/impl/HelloServiceImpl.java

slide 53
 Voir tout le module layout1 :
 /smile-training/wars/layout1

slides 55 -> 65
/smile-training/wars

slide 63 -> 64

A faire, pas compliqué, on run une portlet à partir du thème.
/smile-training/wars/training-theme/src/main/webapp/templates/portal_normal.ftl

Voir le fichier portletKeys des src de Liferay.

Slides 82 -83

/smile-training/modules/formation-web/src/main/java/fr/smile/training/web/portlet/FormationWebPortlet.java

Slide 85
/smile-training/modules/formation-web/src/main/resources/META-INF/resources/edit.jsp

Slides 86 -> 87
/smile-training/modules/formation-web/src/main/java/fr/smile/training/web/portlet/FormationWebPortlet.java

Slides 88
smile-training/modules/formation-web/src/main/resources/META-INF/resources/view.jsp

Slides 92 -> 93
/smile-training/modules/Advanced-web/src/main/resources/META-INF/resources/view.jsp

Slide 94

/smile-training/modules/Advanced-web/src/main/resources/META-INF/resources/next.jsp

/smile-training/modules/Advanced-web/src/main/java/fr/smile/training/web/portlet/action/NextPageRenderCommand.java

Slide 95
/smile-training/modules/Advanced-web/src/main/java/fr/smile/training/web/advanced/configuration/AdvancedPortletInstanceConfiguration.java

Slide 96
/smile-training/modules/Advanced-web/src/main/java/fr/smile/training/web/advanced/configuration/AdvancedPortletInstanceConfigurationBeanDeclaration.java

Slide 97
On utilise plus le init.jsp, mais le controller.
Voir ViewMVCRenderCommand et AdvancedPortletConfigurationAction pour la render command par défaut.

l 35ou 37 on donne à la vue l'objet "advancedPortletInstanceConfiguration".

Slide 98

/smile-training/modules/Advanced-web/src/main/java/fr/smile/training/web/portlet/AdvancedPortletConfigurationAction

Slide 99

/smile-training/modules/Advanced-web/src/main/resources/META-INF/resources/configure.jsp

Attention, renseigner dans AdvancedWebPortlet "javax.portlet.init-param.config-template=/configure.jsp" !!!

Slide 100

/Advanced-web/src/main/java/fr/smile/training/web/portlet/configuration/AdvancedPortletConfigurationAction.java
/smile-training/modules/Advanced-web/src/main/java/fr/smile/training/web/portlet/AdvancedPortletConfigurationAction.java

Slide 101 

/smile-training/modules/Advanced-web/src/main/java/fr/smile/training/web/portlet/action/SamplePortletConfigurationIcon.java

ou voir

/smile-training/modules/portlet-configuration-icon

Slides 103 -107

/smile-training/modules/Advanced-web/src/main/java/fr/smile/training/web/advanced/ws/AdvanceWs.java

Slide 110
/smile-training/modules/training-hook/src/main/java/fr/smile/training/action/LogUserLoginAction.java

Slide 114

/smile-training/modules/create-account-jsp-override

ou

/smile-training/modules/create-account-jsp-override/doclib-resource-command-override

Slide 115
/smile-training/modules/create-account-jsp-override/src/main/resources/META-INF/resources/create_account.jsp

Slide 119
/smile-training/modules/training-hook/src/main/java/fr/smile/training/action/ExpandoValuesStartupAction.java

Slide 120 - 123
I18N voir =>
https://dev.liferay.com/zh/develop/tutorials/-/knowledge_base/7-0/localizing-your-application
/smile-training/modules/resource-bundle

Pour surcharger les traductions des modules :

https://dev.liferay.com/zh/develop/tutorials/-/knowledge_base/7-0/overriding-language-keys
smile-training/modules/training-hook/src/main/java/fr/smile/training/action/MyBlogsResourceBundleLoader.java

Slide 124 - 126
/smile-training/modules/user-service-wrapper/src/main/java/com/liferay/blade/samples/service/hook/user/UserLocalServiceHook.java

Nom à revoir !!!!

Slide 129
Marche pas ...
/smile-training/modules/struts-action

et pour les portlets :

/smile-training/modules/struts-portlet-action

Slide 131 -150

Voir /smile-training/modules/faq-training

















Powered By Liferay, Alloyui, Bootstrap.
