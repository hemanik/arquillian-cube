package org.arquillian.cube.kubernetes.impl;

import io.fabric8.kubernetes.clnt.v3_1.KubernetesClient;
import org.jboss.arquillian.core.api.InstanceProducer;
import org.jboss.arquillian.core.api.annotation.ApplicationScoped;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.core.api.annotation.Observes;

public class KubernetesAssistantCreator {

    @Inject
    @ApplicationScoped
    private InstanceProducer<KubernetesAssistant> kubernetesAssistantInstanceProducer;

    public void createKubernetesAssistant(@Observes KubernetesClient kubernetesClient) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        KubernetesAssistant kubernetesAssistant = new KubernetesAssistant(kubernetesClient, kubernetesClient.getNamespace());
        kubernetesAssistantInstanceProducer.set(kubernetesAssistant);
    }

}
